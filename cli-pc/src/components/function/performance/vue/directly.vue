<template>
  <div>
    <div>
      <span class="a-gt-own-span">本月直属员工绩效评分列表</span>
      <el-table :data="directlyStaffListData" border highlight-current-row style="width: 100%">
          <el-table-column type="index" label="序号" width="180"></el-table-column>
          <el-table-column prop="staffName" label="姓名"></el-table-column>
          <el-table-column prop="staffCode" label="编号"></el-table-column>
          <el-table-column label="自评总分">
              <template slot-scope="scope">
                  <span>{{scope.row.ownTotal == '' || scope.row.ownTotal == null ? "暂未自评分" : scope.row.ownTotal}}</span>
              </template>
          </el-table-column>
          <el-table-column label="直属领导评分">
              <template slot-scope="scope">
                  <span>{{scope.row.directlyTotal == '' || scope.row.directlyTotal == null ? "请点击右侧按钮进行评分" : scope.row.directlyTotal}}</span>
              </template>
          </el-table-column>
          <el-table-column label="操作">
              <template slot-scope="scope">
                  <span v-if="scope.row.ownTotal == '' || scope.row.ownTotal == null">请先通知员工完成自评分</span>
                  <span v-else-if="scope.row.directlyBoolean == true">评分已完成</span>
                  <el-button v-else-if="scope.row.directlyBoolean == false" size="small" type="primary" @click="openStaffInfo(scope.row)">开始评分</el-button>
              </template>
          </el-table-column>
      </el-table>
    </div>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="listDirectlyStaffReq.current"
        :page-sizes="[10, 20, 50, 100]" :page-size="listDirectlyStaffReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
    </el-pagination>
  </div>
</template>
<script>
import { requestListDirectlyStaff } from '../api/api';
export default {
  data() {
    return {
      listDirectlyStaffReq: {
        current: 1,
        size: 10
      },
      page: {
        totalNums: 1,
        totalPages: 1
      },
      directlyStaffListData: []
    };
  },
  methods: {
    listDirectlyStaff() {
      // 分页获取组织关系
      requestListDirectlyStaff(this.listDirectlyStaffReq).then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.directlyStaffListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
          console.log(this.page);
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    handleCurrentChange(val) {
      this.listDirectlyStaff();
    },
    handleSizeChange(val) {
      this.listDirectlyStaffReq.size = val;
      // console.log(this.listOrganizeReq.size);
      this.listDirectlyStaff();
    },
    openStaffInfo(staffInfo) {
      // 打开员工绩效评分详情
      this.$router.push({
        path: '/app/performance/directly',
        query: staffInfo
      });
    }
  },
  created() {
    this.listDirectlyStaff();
  }
};
</script>

<style type="text/css" scoped>
  .a-gt-own-span{
    font-size: 14px;
    color: #666;
    display: block;
    padding: 0 18px 25px;
  }
  .el-pagination {
    text-align: right;
    margin-top: 25px;
  }
</style>
