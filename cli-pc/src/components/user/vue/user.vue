<template>
  <div>eferwerwrwr</div>
</template>
<script>
/*import { requestListDepartInfo, requestAddDepartInfo, requestDelDepart ,requestModifyDepart} from "../api/api";*/
export default {
  data() {
    return {

    };
  },
  methods: {

  },
  created(){
    this.ListDepartpartment();
  }
};
</script>
<style>
.el-dialog__body {
    padding: 30px 25px 0 0;
    color: #48576a;
    font-size: 14px;
}
.a-admin-head{
    padding: 35px 0 35px 25px;
}
.a-admin-table{
  margin:0 25px 25px;;
}
.el-pagination {
    float: right;
    margin-right: 20px;
}
.el-dialog {
    position: absolute;
    left: 50%;
    -ms-transform: translateX(-50%);
    transform: translateX(-50%);
    background: #fff;
    border-radius: 2px;
    box-shadow: 0 1px 3px rgba(0,0,0,.3);
    box-sizing: border-box;
    margin-bottom: 50px;
    margin-left: 80px;
    margin-top: 165px;
}
</style>
