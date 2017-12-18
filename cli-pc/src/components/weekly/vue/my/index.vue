<style lang="less"></style>
<template>
  <div>
    <el-alert title="警告提示的文案" type="warning">
    </el-alert>
    <div style="margin:20px 0">
      <el-button type="primary" @click="add">新增周报</el-button>
    </div>
    <div>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column type="index" width="50">
        </el-table-column>
        <el-table-column prop="name" label="内容">
        </el-table-column>
        <el-table-column prop="province" label="状态">
        </el-table-column>
        <el-table-column label="更新时间" width="180">
          <template slot-scope="scope">
            <el-icon name="time"></el-icon>
            <span style="margin-left: 10px">{{ scope.row.date }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- <el-alert title="上周内容" type="info" :closable="false">
    </el-alert>
    <el-alert title="本周内容" type="info" :closable="false">
    </el-alert> -->
  </div>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }]
      }
    },
    methods: {
      handleClick(row) {
        console.log(row);
      },
      add() {
        this.$router.push({
          path: '/weekly/add'
        })
      }
    },
  }

</script>
