// 绩效总览
<template>
  <div>
    <el-table border :data="performanceData" v-loading="loading" style="width: 100%">
        <el-table-column type="expand">
        <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="评级">
                <span>{{ props.row.level }}</span>
            </el-form-item>
            </el-form>
        </template>
        </el-table-column>
        <el-table-column type="index" label="序号" width="100%"></el-table-column>
        <el-table-column label="姓名" prop="staffName"></el-table-column>
        <el-table-column label="月份">
            <template slot-scope="scope">
                  <el-icon name="time"></el-icon>
                  <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.monthTime, "yyyy-MM") }}</span>
              </template>
        </el-table-column>
    </el-table>
  </div>
</template>
<script>
import { requestListTotal } from "../api/api";
export default {
  data() {
    return {
      performanceData: [],
      loading: false
    };
  },
  methods: {
    ListTotal() {
      this.loading = true;
      requestListTotal().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.performanceData = data.data;
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
        this.loading = false;
      });
    }
  },
  created() {
    this.ListTotal();
  }
};
</script>
<style>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>