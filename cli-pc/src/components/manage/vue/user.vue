<template>
  <div>
    <div>
      <div class="a-admin-head">
        <el-button type="primary" @click="openAddUser" style="margin-right:15px;">新增</el-button>
        <el-input placeholder="登录名/真实姓名" icon="search" v-model="userListReq.useSearch" :on-icon-click="searchClick" style="width:250px;"></el-input>
        <!--<el-select v-model="value" placeholder="请选择">-->
          <!--<el-option-->
            <!--v-for="item in options"-->
            <!--:key="item.value"-->
            <!--:label="item.label"-->
            <!--:value="item.value">-->
          <!--</el-option>-->
        <!--</el-select>-->
        <el-select v-model="userListReq.state" placeholder="用户状态" @change="changeStatus">
              <el-option label="正常" value="正常"></el-option>
              <el-option label="停用" value="停用"></el-option>
        </el-select>
      </div>
      <div class="a-admin-table">
        <el-table :data="userPage.data" border highlight-current-row style="width: 100%">
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column prop="loginName" label="登录名"></el-table-column>
          <el-table-column prop="userName" label="真实姓名"></el-table-column>
          <el-table-column prop="userStatus" label="状态">
             <template slot-scope="scope">
               {{scope.row.userStatus}}
             </template>
          </el-table-column>
          <el-table-column label="创建时间">
            <template slot-scope="scope">
              <el-icon name="createTime"></el-icon>
              <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
              <template  slot-scope="scope">
              <el-button size="small"  @click="editUser(scope.row)">编辑</el-button>
              <el-button size="small" @click="Disable()">停用</el-button>
              <el-button size="small" type="danger" @click="delUser(scope.$index,userPage.data)">删除</el-button>
              <el-button size="small"   @click="dialogVisible = true">关联</el-button>
                <el-button size="small" >详情</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <!--<el-pagination @current-change="handleCurrentChange"
                     :current-page.sync="userListReq.current" :page-size="userListReq.size" layout="total, prev, pager, next" :total="page.totalNums">
      </el-pagination>-->
    </div>
    <div>
        <el-dialog :title="dialogOpe.name" :visible.sync="dialogFormVisible">
          <el-form :model="userAddReq">
            <el-form-item label="登录名" :label-width="formLabelWidth">
              <el-input v-model="userAddReq.loginName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="真实姓名" :label-width="formLabelWidth">
              <el-input v-model="userAddReq.userName" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="状态" :label-width="formLabelWidth">
              <el-select v-model="userAddReq.userStatus" placeholder="用户状态">
                <el-option label="正常" value="正常"></el-option>
                <el-option label="停用" value="停用"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogConfirm(dialogOpe.status)">确 定</el-button>
          </div>
        </el-dialog>
    </div>
    <div>
      <el-dialog title="提示"  :visible.sync="dialogVisible" width="30%"s>
          <el-button type="primary" >关联姓名</el-button>
          <el-button type="primary">关联角色</el-button>
          <span slot="footer" class="dialog-footer">
             <el-button @click="dialogVisible = false">取 消</el-button>
             <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
      </el-dialog>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userListReq: {   //部门列表-对象
        userSearch :"",
        current: '1',
        state:"正常",
        size: 8,
      },
      userPage: {
          page:{totalNums: 1, totalPages: 1},
          data:[]

      },
      dialogFormVisible: false,
      dialogVisible: false,
      formLabelWidth: '120px',
      userAddReq :{  //新增对象
        loginName : "",
        userName  : "",
        userStatus : ""
      },
      /*relationReq :{
        Name : "",
        role : ""
      },*/
      dialogOpe: {  //确定判断状态
        status: 0 // 0：无，1：新增，2：编辑
      },
//      rules: {
//        loginName: [
//          {required: true, message: '请输入员工名称', trigger: 'blur'},
//        ],
//        number: [
//          {required: true, message: '请输入工号', trigger: 'blur'},
//        ],
//        department : [
//          {required: true, message: '请输入部门', trigger: 'blur'}
//        ],
//        phone : [
//          {required: true, message: '请输入手机号码', trigger: 'blur'}
//        ],
//        notice: [
//          {required: true, message: '请上传展示页图片', trigger: 'change'}
//        ],
//        headImageUrl: [
//          {required: true, message: '请上传详情页头像', trigger: 'blur'},
//        ]
//      },
    };
  },
  methods: {
    openAddUser(){     //新增
        this.dialogOpe.name = "新增用户列表";
        this.userAddReq = {};
        this.dialogFormVisible = true;
        this.dialogOpe.status = 1;

    },
    dialogConfirm(status){  //新增确定事件
        var vm = this;
        var a = {   //声明a对象
          loginName:vm.userAddReq.loginName,
          userName:vm.userAddReq.userName,
          userStatus:vm.userAddReq.userStatus,
        }
        if(status == 1){
            vm.dialogFormVisible =false;
            vm.userPage.data.push(a);
        }
        else if(status == 2){
            this.dialogFormVisible = false;
        }
    },
    searchClick(){  // 搜索
       this.getUserList()
       var list = this.userPage.data;  //定义数组
       var namePhone = this.userListReq.useSearch.trim();  //获取输入框的值  //trim()去掉input输入框的前后空格
          for(var i = 0 ; i < list.length ; i++ ){   //遍历数组
//            console.log(list[i].loginName.indexOf(namePhone))
            if(list[i].loginName.indexOf(namePhone) == -1 && list[i].userName.indexOf(namePhone) == -1){  //返回大于等于0的整数值，若不包含"Text"则返回"-1
              this.userPage.data.splice(i, 1);//从数组删除索引为i的对象
              i--;
            }
          }
    },
     editUser(obj){ //编辑
         this.dialogOpe.name = "编辑用户表格";
         console.log(obj)
         this.userAddReq = obj;
       this.dialogFormVisible = true;
       this.dialogOpe.status = 2;

     },
    Relation(){ //关联
//      this.relationReq = {};
      this.dialogVisible = true;
    },
//    Disable(){ //停用
//
//    },
    delUser($index,data){      //删除
      console.log($index)
      this.$confirm('此操作将永久删除该部门, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        data.splice($index, 1);//从数组删除索引为$index的对象
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleCurrentChange(){ //分页

    },
    //调用列表的数据
    getUserList(){
        var vm = this;
        //调接口
        var obj = {
            page: {
                totalNums: 20,
                totalPages: 3
            },
            data:[
              {
                loginName: '小',
                userName: '严惠婷',
                userStatus: '停用',
                id:1
              },
              {
                loginName: '小强',
                userName: '曹伟强',
                userStatus: '正常',
                id:2
                //kkk:true
              },
              {
                loginName: 'asd',
                userName: 'gdfg',
                userStatus: '停用',
                id:3,
                //kkk:false
              },
              {
                loginName: 'gfdgdfg',
                userName: 'asf',
                userStatus: '停用',
                id:3
              }
            ],
        };
        this.userPage = obj;
    },
    changeStatus(){   //下拉框
        console.log(this.userListReq.state,'状态') //打印状态
       console.log(this.userPage)
      var gg = this.userPage.data
      for(var i=0;i<gg.length;i++){
        if(this.userListReq.state == gg[i].userStatus){
            console.log(gg[i].userStatu)
        }
      }
      this.userPage.data=[{
         loginName: 'gfdgdfg',
         userName: 'asf',
         userStatus: '停用',
         id:3
       }]
    }
  },
  mounted(){
    this.getUserList();
    var yy = [{
      id:'1',
      name: '11',
      phone: '1245245242',
    }, {
      id:'2',
      name: '22',
      phone: '1245245242',
    }, {
      id:'2',
      name: '33',
      phone: '1245245242',
    }, {
      id:'1',
      name: '44 ',
      phone: '1245245242',
    }
    ]
    var abc = []
        for(var i=0; i<yy.length;i++){
           console.log(yy[i])
            yy[3].name = '55454'
            yy[1].address= 'scdwe'
            yy[i].name = 'name'+i
        }

//    if(yy[i].id == '1' ){
//       console.log(yy[i])
//    }
//      var gg = [{
//        id:1,
//        name:'lxq'
//      },{
//        id:2,
//        name:'lxq2',
//        //address:'address'
//      },{
//        id:2,
//        name:'lxq2',
//        //address:'address'
//      },{
//        id:3,
//        name:'lxq2',
//        //address:'address'
//      }]
//          var newG = []
//          for(var i=0;i<gg.length;i++){ //遍历数组
//                if(gg[i].id == 2 || gg[i].id == 1){
//                    newG.push(gg[i])
//                }
//          }
//        console.log(newG)
//          gg[1].address = 'address'
//          gg[1].name = 'name3'
//          gg[0].name = 'name3'
//          for(var i=0;i<gg.length;i++){
//                console.log(i)
//            gg[i].name = 'name'+i
//          }
//            console.log(gg)
//        }
      }
};
</script>

