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
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
          <el-input v-model="ruleForm.yonghuzhanghao" readonly              placeholder="用户账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
          <el-input v-model="ruleForm.yonghuxingming"               placeholder="用户姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="手机号码" prop="shoujihaoma">
          <el-input v-model="ruleForm.shoujihaoma"               placeholder="手机号码" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='shangjia'"  label="商家账号" prop="shangjiazhanghao">
          <el-input v-model="ruleForm.shangjiazhanghao" readonly              placeholder="商家账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='shangjia'"  label="商家名称" prop="shangjiamingcheng">
          <el-input v-model="ruleForm.shangjiamingcheng"               placeholder="商家名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='shangjia'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="shangjiatupianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='shangjia'"  label="联系人" prop="lianxiren">
          <el-input v-model="ruleForm.lianxiren"               placeholder="联系人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='shangjia'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='shangjia'"  label="商家地址" prop="shangjiadizhi">
          <el-input v-model="ruleForm.shangjiadizhi"               placeholder="商家地址" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"width":"50%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#f5b688","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
    <el-form-item :style='{"width":"100%","margin":"30px 0 20px 0","display":"inline-block", "background":"rgb(138, 164, 189)"}'   v-if="flag=='shangjia'"  label="报表">
    </el-form-item>
    <el-form-item :style='{"padding":"0","margin":"0"}' label="销量" v-if="flag=='shangjia'">
      <div class="EchartPractice">
        <div id="main" class="chart" ref="main"></div>
      </div>
    </el-form-item>
    <el-form-item :style='{"padding":"0","margin":"0"}' label="销售额" v-if="flag=='shangjia'">
      <div class="EchartPractice">
        <div id="saleMain" class="chart"></div>
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
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
        
          let myEchart = this.$echarts.init(document.getElementById("main"));
          let option = {
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
              symbolSize:3,//一定要加这个字段才能显示
              itemStyle:{
                normal:{
                  label:{
                    show:true,
                    position:'top',
                    fontSize:11,
                    textStyle:{                    
                      color:'black'
                    }
                  }
                }
              },
              data: data.data.numLists,
              type: 'line',
              smooth: true,
              areaStyle: {
                color: '#344CE9',
                opacity: 0.5
              }
            }]
          };
          myEchart.setOption(option);

          
          let saleEchart = this.$echarts.init(document.getElementById("saleMain"));
          let saleOption = {
            xAxis: {
              data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
              show: true,  //   前提：  y轴肯定是要显示的
              name: "单位:元",  //  你的单位写在这就可以
              nameTextStyle: {   //  单位样式
              fontSize: 10, 	//  字体大小
              padding: [0,15,4,0]		//  内填充
              }
            },
            series: [{
              symbolSize:3,//一定要加这个字段才能显示
              itemStyle:{
                normal:{
                  label:{
                    show:true,
                    position:'top',
                    fontSize:11,
                    textStyle:{                    
                      color:'black'
                    }
                  }
                }
              },
              data: data.data.discounttotalLists,
              type: 'line',
              smooth: true,
              areaStyle: {
                color: '#344CE9',
                opacity: 0.5
              }
            }]
          };
          saleEchart.setOption(saleOption);
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "男,女".split(',')
    this.yonghuvipOptions = "是,否".split(',')
  },
  methods: {
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    shangjiatupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
        this.$message.error('用户账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'yonghu' ==this.flag && this.ruleForm.shoujihaoma&&(!isMobile(this.ruleForm.shoujihaoma))){
        this.$message.error(`手机号码应输入手机格式`);
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.jf&&(!isNumber(this.ruleForm.jf))){
        this.$message.error(`积分应输入数字`);
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
        this.$message.error(`余额应输入数字`);
        return
      }
      if((!this.ruleForm.shangjiazhanghao)&& 'shangjia'==this.flag){
        this.$message.error('商家账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'shangjia'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.shangjiamingcheng)&& 'shangjia'==this.flag){
        this.$message.error('商家名称不能为空');
        return
      }
        if(this.ruleForm.tupian!=null) {
                this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'shangjia' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if( 'shangjia' ==this.flag && this.ruleForm.jf&&(!isNumber(this.ruleForm.jf))){
        this.$message.error(`积分应输入数字`);
        return
      }
      if( 'shangjia' ==this.flag && this.ruleForm.money&&(!isNumber(this.ruleForm.money))){
        this.$message.error(`余额应输入数字`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
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
