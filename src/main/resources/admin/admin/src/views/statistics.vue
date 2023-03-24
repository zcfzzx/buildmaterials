<template>
  <div :style='{"padding":"30px 50px"}'>
    <el-form
	  :style='{"padding":"30px","boxShadow":"0 1px 6px #8aa4bd","borderRadius":"6px","background":"rgba(255, 255, 255, 0.9)"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="140px"
    >  
     <el-row>
    <el-form-item :style='{"padding":"0","margin":"0"}' label="新增用户" >
      <div class="EchartPractice">
        <div id="user" class="chart" ref="main"></div>
      </div>
    </el-form-item>
    <el-form-item :style='{"padding":"0","margin":"0"}' label="新增商家" >
      <div class="EchartPractice">
        <div id="shangjia" class="chart"></div>
      </div>
    </el-form-item>
    <el-form-item :style='{"padding":"0","margin":"0"}' label="销量" >
      <div class="EchartPractice">
        <div id="sales" class="chart"></div>
      </div>
    </el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";
  import Vue from 'vue';
  import echarts from "echarts";
  Vue.prototype.$echarts = echarts;

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
      yonghuvipOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `statistics/list`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
        
          let userEchart = this.$echarts.init(document.getElementById("user"));
          let userOption = {
            xAxis: {
              data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
              show: true,  //   前提：  y轴肯定是要显示的
              name: "单位:人",  //  你的单位写在这就可以
              nameTextStyle: {   //  单位样式
              fontSize: 10, 	//  字体大小
              padding: [0,15,4,0]		//  内填充
              }
            },
            series: [{
              data: data.data.yongHuCountList,
              type: 'line',
              smooth: true,
              symbol: "none",
              areaStyle: {
                color: '#344CE9',
                opacity: 0.5
              }
            }]
          };
          userEchart.setOption(userOption);

          
          let shangjiaEchart = this.$echarts.init(document.getElementById("shangjia"));
          let shangjiaOption = {
            xAxis: {
              data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
              show: true,  //   前提：  y轴肯定是要显示的
              name: "单位:人",  //  你的单位写在这就可以
              nameTextStyle: {   //  单位样式
              fontSize: 10, 	//  字体大小
              padding: [0,15,4,0]		//  内填充
              }
            },
            series: [{
              data: data.data.shangJiaCountList,
              type: 'line',
              smooth: true,
              symbol: "none",
              areaStyle: {
                color: '#344CE9',
                opacity: 0.5
              }
            }]
          };
          shangjiaEchart.setOption(shangjiaOption);
          
          let salesEchart = this.$echarts.init(document.getElementById("sales"));
          let salesOption = {
            xAxis: {
              data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
              show: true,  //   前提：  y轴肯定是要显示的
              name: "单位:单",  //  你的单位写在这就可以
              nameTextStyle: {   //  单位样式
              fontSize: 10, 	//  字体大小
              padding: [0,15,4,0]		//  内填充
              }
            },
            series: [{
              data: data.data.buyNumberCountList,
              type: 'line',
              smooth: true,
              symbol: "none",
              areaStyle: {
                color: '#344CE9',
                opacity: 0.5
              }
            }]
          };
          salesEchart.setOption(salesOption);
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  font-weight: 500;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
      
   .chart {
    width: 600px;
    height:400px;
    margin: auto;
    margin-top: 10px;
    float:left;
  }
</style>
