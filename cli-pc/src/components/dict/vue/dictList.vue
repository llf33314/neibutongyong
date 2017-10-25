<template>
  <div>
      <el-input
        placeholder="请选择日期"
        icon="search"
        v-model="input2"
        :on-icon-click="handleIconClick">
      </el-input>
  </div>
</template>
<script>
export default {
  data() {
    return {
      input2: ""
    };
  },
  methods: {
    handleIconClick(ev) {
      console.log(ev);
    }
  }
};
</script>

