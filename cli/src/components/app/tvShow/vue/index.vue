<template>
  <section class="bg">
    <ul class="title">
      <li>项目名称</li>
      <li>倒计时</li>
    </ul>
    <swiper :options="swiperOption" :style="style">
      <swiper-slide v-for="(item,index) in swiperSlides" :key="index">
        <ul class="project-item" v-for="(child,index) in item" :key="index">
          <li v-text="child.projectName"></li>
          <li v-if="child.endDayNum !=0"><span style="font-size:250%">{{child.endDayNum}}</span> 天</li>
          <li v-if="child.endDayNum ==0"><span style="font-size:200%">今天</span>验收</li>
        </ul>
      </swiper-slide>
      <div v-show="swiperSlides.length >1" class="swiper-pagination" slot="pagination"></div>
    </swiper>
  </section>
</template>

<script>
  
  import {
    swiper,
    swiperSlide
  } from 'vue-awesome-swiper'
  import {
    requestListProject
  } from './../api/api.js'
  export default {
    name: 'index',
    components: {
      swiper,
      swiperSlide
    },
    data() {
      return {
        swiperOption: {
          autoplay: 5500,
          pagination: '.swiper-pagination',
          height: 500,
          loop: true,
        },
        swiperSlides: [],
        style: {
          height: '500px'
        }
      }
    },
    mounted() {
      this.style.height = window.innerHeight - 90 + 'px'
      this.getData()
    },
    methods: {
      // 请求数据
      getData() {
        requestListProject().then(res => {
          if (res.code == 100) {
            console.log(res.data)
            console.log(this.splitData(res.data))
            this.swiperSlides = this.splitData(res.data)
          } else {
            this.$message.error('链接超时');
          }
        })
      },
      // 重新拆分数据格式[ [{},{},{}],[{},{},{}] ]
      splitData(data) {
        var mm = []
        var nn = []
        var tt = data.length % 3
        data.forEach(function (item, index) {
          nn.push(item)
          if ((index + 1) % 3 == 0) {
            mm.push(nn)
            nn = []
          }
        });
        if(tt != 0){
          mm.push(data.slice(tt * -1))
        }
        return mm
      }
    }
  }

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style type="text/css" >
  @import "./../../../../../static/css/swiper-3.4.2.min.css";
  .bg {
    background-image: url(./../img/1.jpg)
  }
  * {
    box-sizing: border-box;
    font-family: "Microsoft Yahei";
    margin:0;
    padding:0;
  }

  .title {
    height: 90px;
    border-bottom: 1px solid #6c6c6c;
  }

  .title li {
    width: 50%;
    float: left;
    list-style-type: none;
    text-align: center;
    line-height: 90px;
    font-weight: 700;
    font-size: 200%;
    color: #e9e9e9;
  }

  .title li:first-child {
    border-right: 1px solid #6c6c6c;
  }

  .project-item {
    width: 100%;
    height: 33.3%;
    border-bottom: 1px solid #6c6c6c;
  }

  .project-item li {
    width: 50%;
    height: 100%;
    float: left;
    list-style-type: none;
    text-align: center;
    line-height: 100%;
    font-weight: 700;
    font-size: 300%;
    /* Firefox */
    display: -moz-box;
    -moz-box-pack: center;
    -moz-box-align: center;
    /* Safari、Opera 以及 Chrome */
    display: -webkit-box;
    -webkit-box-pack: center;
    -webkit-box-align: center;
    /* W3C */
    display: box;
    box-pack: center;
    box-align: center;
    color: #e9e9e9;
  }

  .project-item li:first-child {
    border-right: 1px solid #6c6c6c;
  }

  .bg .swiper-pagination-bullet {
    background: #fff;
    opacity: 1;
  }

  .bg .swiper-pagination-bullet-active {
    opacity: 1;
    background: #007aff;
  }

</style>
