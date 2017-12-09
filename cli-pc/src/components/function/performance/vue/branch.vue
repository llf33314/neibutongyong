// 分管领导评分
<style lang="less">
  .functioin-performace-branch {
    .a-gt-own-span {
      font-size: 14px;
      color: #666;
      display: block;
      padding: 7px 20px 25px;
    }

    .el-pagination {
      text-align: right;
      margin-top: 25px;
    }
  }

</style>
<template>
  <div class="functioin-performace-branch">
    <div>
      <div style="margin: 0px 0 10px">
        <el-button type="primary" @click="releaseLevelClick" :disabled="releaseLevelBoolean == false">发布评级</el-button>
        <el-button type="primary" @click="exportExcelClick" :disabled="releaseLevelBoolean == false">导出数据</el-button>
      </div>
      <span class="a-gt-own-span">本月分页员工绩效评级列表</span>
      <el-table :data="branchStaffListData" border highlight-current-row style="width: 100%">
        <el-table-column type="index" label="序号" width="180"></el-table-column>
        <el-table-column prop="staffName" label="姓名"></el-table-column>
        <el-table-column prop="staffCode" label="编号"></el-table-column>
        <!-- <el-table-column prop="staffDuties" label="职务"></el-table-column> -->

        <el-table-column prop="staffDuties" label="职务" :filters="dutiesFilters" :filter-method="filterTag" filter-placement="bottom-end">
          <template slot-scope="scope">
            {{scope.row.staffDuties}}
          </template>
        </el-table-column>

        <el-table-column label="自评总分">
          <template slot-scope="scope">
            <span>{{scope.row.ownTotal == '' || scope.row.ownTotal == null ? "暂未自评分" : scope.row.ownTotal}}</span>
          </template>
        </el-table-column>
        <el-table-column label="直属领导评分">
          <template slot-scope="scope">
            <span>{{scope.row.directlyTotal == '' || scope.row.directlyTotal == null ? "暂未评分" : scope.row.directlyTotal}}</span>
          </template>
        </el-table-column>
        <el-table-column label="评级">
          <template slot-scope="scope">
            <span>{{scope.row.level == '' || scope.row.level == null ? "请点击右侧按钮进行评级" : scope.row.level}}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <span v-if="scope.row.ownTotal == '' || scope.row.ownTotal == null">需员工完成自评分</span>
            <span v-else-if="scope.row.directlyTotal == '' || scope.row.directlyTotal == null">需员工直属领导完成评分</span>
            <span v-else-if="scope.row.levelBoolean == true">评级已完成</span>
            <el-button v-else-if="scope.row.levelBoolean == false" size="small" type="primary" @click="openStaffLevel(scope.row)">评级</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="listBranchStaffReq.current"
      :page-sizes="[10, 20, 50, 100]" :page-size="listBranchStaffReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
    </el-pagination>
    <div>
      <el-dialog :title="addLevelReq.staffName + '评级'" :visible.sync="gradeDialogBoolean">
        <el-select v-model="addLevelReq.level" placeholder="请选择评级">
          <el-option v-for="item in levelData" :key="item.levelCode" :label="item.levelName" :value="item.levelCode"></el-option>
        </el-select>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="gradeDialogBoolean = false">取 消</el-button>
          <el-button type="primary" @click="confim()">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  import {
    requestListBranchStaff,
    requestListLevelDict,
    requestAddLevel,
    requestCheckReleaseLevel,
    requestReleaseLevel,
    requestExportExcel
  } from '../api/api';
  export default {
    data() {
      return {
        listBranchStaffReq: {
          current: 1,
          size: 10
        },
        page: {
          totalNums: 1,
          totalPages: 1
        },
        branchStaffListData: [],
        addLevelReq: {
          staffId: '',
          staffName: '',
          level: ''
        },
        levelData: [],
        releaseLevelBoolean: false,
        gradeDialogBoolean: false,
        dutiesFilters: [
          { text: '项目负责人', value: '项目负责人（Java）' }, 
          { text: '项目负责人', value: '项目负责人（安卓）' }, 
          { text: 'Java/Web/安卓', value: 'Java' }, 
          { text: 'Java/Web/安卓', value: 'Web' }, 
          { text: 'Java/Web/安卓', value: '安卓' }, 
          { text: '测试', value: '测试' },
          { text: '管理', value: '部门经理' },
          { text: '管理', value: '总经理' },
        ]
      };
    },
    methods: {
      listBranchStaff() {
        // 分页获取分管员工
        requestListBranchStaff(this.listBranchStaffReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.branchStaffListData = data.data;
            this.page.totalNums = data.page.totalNums;
            this.page.totalPages = data.page.totalPages;
            console.log(this.page);
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      listLevelDict() {
        // 获取等级字典信息
        requestListLevelDict().then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.levelData = data.data;
            console.log(this.page);
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      addLevel() {
        // 保存评级
        requestAddLevel(this.addLevelReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '评级成功',
              type: 'success'
            });
            this.listBranchStaff();
            this.checkReleaseLevel();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      checkReleaseLevel() {
        // 判断评级是否可发布
        requestCheckReleaseLevel(this.addLevelReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.releaseLevelBoolean = data.data;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      releaseLevel() {
        // 发布评级
        this.$confirm('发布评级后将不可修改，相关人员也能看到对应评级，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestReleaseLevel().then(data => {
            console.log(data);
            var _code = data.code;
            if (_code == 100) {
              this.$message({
                message: '发布评级成功',
                type: 'success'
              });
              this.listBranchStaff();
              this.checkReleaseLevel();
            } else {
              this.$message.error(data.msg + '[错误码：' + _code + ']');
            }
          });
        });
      },
      exportExcel() {
        // 导出excel
        // this.$message({
        //   message: '功能暂未开放，敬请期待'
        // });
        requestExportExcel().then(function (response) {
          // window.location.href = URL.createObjectURL(new Blob([response]));
          const content = response;
          const elink = document.createElement('a'); // 创建a标签
          elink.download = '员工绩效评定表.xls'; // 文件名
          elink.style.display = 'none';
          const blob = new Blob([content]);
          elink.href = URL.createObjectURL(blob);
          document.body.appendChild(elink);
          elink.click() // 触发点击a标签事件
          document.body.removeChild(elink);
        });
      },
      handleCurrentChange(val) {
        this.listBranchStaff();
      },
      handleSizeChange(val) {
        this.listBranchStaffReq.size = val;
        // console.log(this.listOrganizeReq.size);
        this.listBranchStaff();
      },
      openStaffLevel(branchStaff) {
        // 开始评级
        console.log('openStaffLevel');
        this.addLevelReq.staffName = branchStaff.staffName;
        this.addLevelReq.staffId = branchStaff.staffId;
        this.addLevelReq.level = branchStaff.level;
        this.gradeDialogBoolean = true;
        console.log(this.addLevelReq);
      },
      confim() {
        // 保存等级
        this.gradeDialogBoolean = false;
        this.addLevel();
      },
      releaseLevelClick() {
        // 发布评级
        this.releaseLevel();
      },
      exportExcelClick() {
        // 导出数据
        this.exportExcel();
      },
      filterTag(value, row) {
        return row.staffDuties === value;
      }
    },
    created() {
      this.listBranchStaff();
      this.checkReleaseLevel();
      this.listLevelDict();
    }
  };

</script>
