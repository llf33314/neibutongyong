<template>
    <div id="main" class="app-main">
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                theme: this.$store.state.app.themeColor
            };
        },
        mounted() {

        },
        beforeDestroy() {

        },
        methods: {

        }
    };
</script>

<style>
    .app-main {
        width: 100%;
        height: 100%;
    }

    .el-pagination {
        float: right;
        margin-top: 20px;
    }

    .a-admin-head {
        padding: 10px 0 20px;
    }

    .main .single-page-con .single-page {
        background-color: #ffffff;
        margin: 10px;
        padding: 10px;
        border: 1px solid #dddee1;
        border-color: #e9eaec;
        overflow: hidden;
        transition: all .2s ease-in-out;
    }

    .main .single-page-con .single-page:hover {
        box-shadow: 0 1px 6px rgba(0, 0, 0, .2);
        border-color: #eee;
    }
</style>