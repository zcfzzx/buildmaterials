<template>
    <div v-if="show" class="mask">
      <div class="dlg-input-box flex flex-col">
        <div class="flex flex-space-between full-width">
          <div class="font-bold">{{caption}}</div>
          <div class="pointer" @click="close">关闭</div>
        </div>
        <div class="margin-top-xl flex flex-col">
            <input class="input-box" placeholder="请输入" v-model="inputValue" ref="getfocus"/>
        </div>
        <div class="flex flex-end margin-top-xl">
          <div class="btn-huibai-auto pointer" style="width:80px" @click="cancelClick">取消</div>
          <div class="margin-left-m btn-blue-auto pointer" style="width:80px" @click="confirmClick">确定</div>
        </div>
      </div>
      <msg-show caption="提示" :msg="msgText" :show="showMessage" @close="showMessage=false"></msg-show>    
    </div>
  </template>
<script>
import MsgShow from './msgbox'; 
 export default {
      name: 'InputBox',//组件递归必须有name属性 不然无法递归    
      props: {
          caption:{},
          value:{},
          show: {},
      },
      components: {
        MsgShow
      },
      watch: {
        show(val){
            if (val == true) {
                this.$nextTick(() => {
                    this.$refs.getfocus.focus();
                })
            }
        },
        value(val){
          this.inputValue = val;
        }
 
      },
      data() {
          return {
            showMessage:false,
            inputValue:'',
            msgText:''
          }
      },
      
      methods: {
       
          close() {
			this.inputValue = "快递单号"; 
            this.$emit('close');
          },
          confirmClick() {
            if (this.inputValue == "" || this.inputValue == '快递单号') {
                this.msgText = "内容未填写";
                this.showMessage = true;
            } else {
                this.$emit('confirm', this.inputValue);
				this.inputValue = "快递单号"; 
            }
            
          },
          cancelClick() {          
			this.inputValue = "快递单号"; 
            this.$emit('cancel');
          }
  
      }
  }
</script>

<style lang="scss" scoped>
	.dlg-input-box {
          border-radius: 5px;
          width: 350px;
          height: 160px;
          background-color: #fff;
          padding: 30px;
          position: absolute;
          top: 0;
          bottom: 0;
          left: 0;
          right: 0;
          margin: auto;
      }
/* flex布局 */ 
.flex {
    display: flex;
}

/* 横向排列 */ 
.flex-col {
    flex-direction: column;
}

/* 纵向排列 */ 
.flex-row {
    flex-direction: row;
}

/* 水平居中 */ 
.flex-center-sp {
    justify-content: center;
}

/* 垂直居中 */ 
.flex-center-cz {
    align-items: center;
}

/* 从左往右排 */ 
.flex-start {
    justify-content: flex-start;
}

/* 从右往左排 */ 
.flex-end {
    justify-content: flex-end;
}

/* 两端靠边 */ 
.flex-space-between {
    justify-content: space-between;
}

/* 平均分布空间 */ 
.flex-space-evenly {
    justify-content: space-evenly;
}

.position-relative {
    position: relative;
}

.position-absolute {
    position: absolute;
}

.position-fixed {
    position: fixed;
}

.full-width {
    width: 100%;
}

.full-height {
    height: 100%;
}

/* 外间隔 */ 
.margin-s {
    margin: 5px;
}

.margin-m {
    margin: 10px;
}

.margin-l {
    margin: 15px;
}

.margin-xl {
    margin: 25px;
}

.margin-left-s {
    margin-left: 5px;
}

.margin-left-m {
    margin-left: 10px;
}

.margin-left-l {
    margin-left: 15px;
}

.margin-left-xl {
    margin-left: 25px;
}


.margin-right-s {
    margin-right: 5px;
}

.margin-right-m {
    margin-right: 10px;
}

.margin-right-l {
    margin-right: 15px;
}

.margin-right-xl {
    margin-right: 25px;
}

.margin-top-s {
    margin-top: 5px;
}

.margin-top-m {
    margin-top: 10px;
}

.margin-top-l {
    margin-top: 15px;
}

.margin-top-xl {
    margin-top: 10px;
}

.margin-bottom-s {
    margin-bottom: 5px;
}

.margin-bottom-m {
    margin-bottom: 10px;
}

.margin-bottom-l {
    margin-bottom: 15px;
}

.margin-bottom-xl {
    margin-bottom: 25px;
}

/* 内间隔 */ 
.padding-s {
    padding: 5px;
}

.padding-m {
    padding: 10px;
}

.padding-l {
    padding: 15px;
}

.padding-xl {
    padding: 25px;
}


.padding-left-s {
    padding-left: 5px;
}

.padding-left-m {
    padding-left: 10px;
}

.padding-left-l {
    padding-left: 15px;
}

.padding-left-xl {
    padding-left: 25px;
}



.padding-right-s {
    padding-right: 5px;
}

.padding-right-m {
    padding-right: 10px;
}

.padding-right-l {
    padding-right: 15px;
}

.padding-right-xl {
    padding-right: 25px;
}

.padding-top-s {
    padding-top: 5px;
}

.padding-top-m {
    padding-top: 10px;
}

.padding-top-l {
    padding-top: 15px;
}

.padding-top-xl {
    padding-top: 25px;
}

.padding-bottom-s {
    padding-bottom: 5px;
}

.padding-bottom-m {
    padding-bottom: 10px;
}

.padding-bottom-l {
    padding-bottom: 15px;
}

.padding-bottom-xl {
    padding-bottom: 25px;
}

/* 字体大小 */ 

.font-ms {
    font-size: 10px;
}

.font-s {
    font-size: 14px;
}

.font-m {
    font-size: 16px;
}

.font-l {
    font-size: 18px;
}

.font-xl {
    font-size: 20px;
}

.font-xxl {
    font-size: 24px;
}

/* 字体粗细 */ 
.font-bold {
    font-weight: 600;
}

/* 颜色 */ 

.color-white {
    color: #fff;
}

.color-black {
    color: #000;
}

.color-blue {
    color: #0070f9;
}

.color-gray {
    color: #8799a3;
}

.color-rgb-01 {
    color: rgba(0, 0, 0, .1);
  }

.color-rgb-03 {
    color: rgba(0, 0, 0, .3);
}

.color-rgb-05 {
    color: rgba(0, 0, 0, .5);
}

.color-rgb-07 {
    color: rgba(0, 0, 0, .7);
}

.bk-color-rgb-01 {
    background-color: rgba(0, 0, 0, .05);
  }

.bk-color-rgb-02 {
    background-color: rgba(0, 0, 0, .2);
}

.bk-color-hb {
    background-color: #f2f8ff;
}

.bk-color-blue {
    background-color: #36a4fd;
    ;
}


.scroll {
    overflow: auto;
}

/* 按钮 */ 

.btn-blue-full {
    display: flex;
    height: 32px;
    width: 90px;
    color: #fff;
    background-color: #36a4fd;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #36a4fd;
}

.btn-blue-full:hover {
    border-color: #0070f9;
    background-color: #0070f9; 
}

.btn-blue-line {
    display: flex;
    height: 32px;
    width: 90px;
    color: #36a4fd;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #36a4fd;
}

.btn-white-full {
    display: flex;
    height: 32px;
    width: 90px;
    color: #36a4fd;
    background-color: #f2f8ff;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #36a4fd;
}

.btn-white-line {
    display: flex;
    height: 32px;
    width: 90px;
    color: #fff;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #fff;
}

.btn-white-line:hover {
    color: #36a4fd;
    background-color: #f2f8ff;
}

.btn-red-full {
    display: flex;
    height: 32px;
    width: 90px;
    color: #fff;
    background-color: #b20f0f;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #b20f0f;
}

.btn-red-full:hover {
    opacity: .8; 
}

.pointer {
    cursor: pointer;
}

/*包含以下四种的链接*/
a {
    text-decoration: none;
}
/*正常的未被访问过的链接*/
a:link {
    text-decoration: none;
}
/*已经访问过的链接*/
a:visited {
    text-decoration: none;
}
/*鼠标划过(停留)的链接*/
a:hover {
    text-decoration: none;
}
/* 正在点击的链接*/
a:active {
    text-decoration: none;
}

.border{
    border-style: solid;
    border-width: 1px;
    border-color: rgba(0, 0, 0, .2);
}

.border-radius-ms{
    border-radius: 5px;
}

.border-radius-s{
    border-radius: 10px;
}

.border-radius-m{
    border-radius: 15px;
}

.border-radius-l{
    border-radius: 20px;
}

.yizhankai {
    width: 10px;
    height: 8px;
    margin-right: 10px;
}

.weizhankai {
    width: 10px;
    height: 10px;
    margin-right: 10px;
}

.wjj {
    width: 15px;
    height: 15px;
    margin-right: 10px;
}

.logo-18 {
    width: 18px;
    height: 18px;
}

.logo-20 {
    width: 20px;
    height: 20px;
}

.logo-22 {
    width: 22px;
    height: 22px;
}

.logo-25 {
    width: 25px;
    height: 250px;
}

/* 遮罩层*/
.mask {
    background-color: rgba(0,0,0,0.4);
    /* 使用固定定位让元素撑满全屏 */
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: 9999;
}

.input-box {
    border:1px solid #36a4fd;
    border-radius: 10px;
    padding-left: 10px;
    padding-right: 10px;
    font-size: 16px;
    background-color: #fff;
    height: 33px;
  }


.btn-blue-auto {
    display: flex;
    height: 35px;
    color: #fff;
    background-color: #36a4fd;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #36a4fd;
}

.btn-blue-auto:hover {
    background-color: #4689db;
}

.btn-huibai-auto {
    display: flex;
    height: 36px;
    color: #000;
    background-color: #f2f8ff;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    border-style: solid;
    border-width: 1px;
    border-color: #f2f8ff;
}

.btn-huibai-auto:hover {
    background-color: #ecf1f7;
}



input:focus {  
    outline: none;  
}

.cannotselect {
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;   
    -ms-user-select: none;
    user-select: none;
    
}
</style>
