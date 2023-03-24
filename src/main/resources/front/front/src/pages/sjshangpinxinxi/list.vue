<template>
<div>
	<div :style='{"border":"1px dashed #7e6b5a","padding":"0 20px","margin":"20px 7%","outline":"1px solid #7e6b5a","borderRadius":"0","alignItems":"center","outlineOffset":"2px","background":"#efefef","display":"flex","width":"86%","height":"56px"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
			<el-breadcrumb-item >欢迎进入我的店铺</el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<!-- <div :style='{"border":"1px dashed #7e6b5a","padding":"0 20px","margin":"20px 7%","outline":"1px solid #7e6b5a","borderRadius":"0","alignItems":"center","outlineOffset":"2px","background":"#efefef","display":"flex","width":"86%","height":"56px"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'Ξ'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item>商家信息</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in breadcrumbItem" :key="index">{{item.name}}</el-breadcrumb-item>
		</el-breadcrumb>
	</div> -->
	
	<div class="list-preview" :style='{"width":"100%","margin":"0 auto","position":"relative","flexWrap":"wrap","background":"none","display":"flex"}'>
        <!-- <div class="category-1" :class="{ 'fixed-style': isFixed }" :style='{"padding":"40px 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
            <div class="item" :class="swiperIndex == '-1' ? 'active' : ''" @click="getList(1, '全部')" :plain="isPlain">全部</div> -->
            <!-- 商品分类导航 -->
            <!-- <div class="item" :class="swiperIndex == index ? 'active' : ''" v-for="(item, index) in fenlei" :key="index"
                 @click="getList(1, item, 'btn' + index)" :ref="'btn' + index" plain>{{item}}</div>
        </div> -->
        <div style="height: 94px" v-if="isFixed"></div>

        <el-form :inline="true" :model="formSearch" class="list-form-pv" :class="{ 'fixed-style2': isFixed2 }" :style='{"padding":"30px 20px ","margin":"20px 7% 0","alignItems":"center","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230206/544f501163914411bf89e5cb898e10ac.png) no-repeat center bottom,linear-gradient(30deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(246,236,223,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#fff","display":"flex","width":"86%","justifyContent":"center","height":"auto"}'>
          <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
            <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>商家名称: {{shangjia.shangjiamingcheng}}</div>
          </el-form-item>
          <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
            <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>联系人: {{shangjia.lianxiren}}</div>
          </el-form-item>
          <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
            <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>联系电话: {{shangjia.lianxidianhua}}</div>
          </el-form-item>
          <el-form-item :style='{"alignItems":"center","margin":"0 4px 0 0","display":"flex"}'>
            <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>商家地址: {{shangjia.shangjiadizhi}}</div>
          </el-form-item>
        </el-form>
        <div style="height: 122px" v-if="isFixed2"></div>

        <div class="list" :style='{"padding":"0 0 20px","margin":"20px 7% 0","background":"none","flex":"1","width":"86%","minWidth":"900px","order":"3"}'>
            <!-- 样式一 -->
            <div class="list1 index-pv1" :style='{"padding":"0","margin":"30px 0 0","overflow":"hidden","background":"none","display":"block","width":"100%","height":"auto"}'>
                <div :style='{"margin":"0 3% 20px 0","flexWrap":"wrap","background":"none","display":"flex","width":"30%","position":"relative","float":"left","justifyContent":"space-between","height":"auto"}' v-for="(item, index) in dataList" :key="index" @click="toDetail(item)" class="list-item animation-box">
                    <img :style='{"padding":"30px","margin":"0 0 10px","objectFit":"cover","background":"url(http://codegen.caihongy.cn/20230207/346e413dce8f4515a5a57219df032ccd.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230207/e75d04594fa6401b9993f023e829f7b8.png) no-repeat right bottom / auto 100%","display":"block","width":"100%","height":"260px"}' v-if="item.tupian && item.tupian.substr(0,4)=='http'" :src="item.tupian" class="image" />
                    <img :style='{"padding":"30px","margin":"0 0 10px","objectFit":"cover","background":"url(http://codegen.caihongy.cn/20230207/346e413dce8f4515a5a57219df032ccd.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230207/e75d04594fa6401b9993f023e829f7b8.png) no-repeat right bottom / auto 100%","display":"block","width":"100%","height":"260px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" class="image" />
                    <div v-if="item.price" :style='{"padding":"4px 10px","color":"red","textAlign":"center","width":"100%","lineHeight":"24px","fontSize":"14px","order":"2"}' class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
                    <div :style='{"padding":"4px 0","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">{{item.shangpinmingcheng}}</div>
                    <div :style='{"padding":"4px 0","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">品牌:{{item.pinpai}}</div>
                    <div :style='{"padding":"4px 0","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}' class="name ">商家名称:{{item.shangjiamingcheng}}</div>
                </div>
            </div>

            <!-- 样式二 -->
        </div>

        <!-- 热门信息 -->
        <div class="hot" :style='{"width":"200px","margin":"40px 7% 0 0","background":"none","height":"auto","order":"4"}'>
          <div :style='{"border":"0 dashed #7e6b5a","padding":"0 0 0 80px","margin":"0 auto 20px","color":"#333","textAlign":"center","outline":"1px solid #7e6b5a","outlineOffset":"2px","background":"url(http://codegen.caihongy.cn/20230207/cb0df322e9b14cb3b11556207d9fab2b.png) no-repeat 20px -1px","borderWidth":"1px 0","width":"100%","lineHeight":"56px","fontSize":"18px","fontWeight":"500"}'>热门信息</div>
          <div :style='{"padding":"10px 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
            <div v-for="item in hotList" :key="item" :style='{"width":"100%","margin":"0 0 20px","background":"none","height":"auto"}' @click="toDetail(item)">
              <img :style='{"padding":"20px","margin":"0 0 10px","objectFit":"cover","background":"url(http://codegen.caihongy.cn/20230207/346e413dce8f4515a5a57219df032ccd.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230207/e75d04594fa6401b9993f023e829f7b8.png) no-repeat right bottom / auto 100%","display":"block","width":"100%","height":"180px"}' :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="">
              <div :style='{"padding":"0 10px","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}'>{{item.shangpinmingcheng}}</div>
              <div :style='{"padding":"0 10px","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}'>{{item.pinpai}}</div>
              <div :style='{"padding":"0 10px","margin":"0 auto","whiteSpace":"nowrap","overflow":"hidden","color":"#fff","textAlign":"center","background":"linear-gradient(270deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c","width":"86%","lineHeight":"24px","fontSize":"14px","textOverflow":"ellipsis"}'>{{item.shangjiamingcheng}}</div>
              <!--<div :style='{"padding":"0 10px","lineHeight":"12px","fontSize":"14px","color":"#999","textAlign":"right","display":"none"}'>2022-02-02</div>-->
            </div>
          </div>
        </div>

        <el-pagination
          background
          class="pagination"
          :pager-count="7"
          :page-size="pageSize"
          :page-sizes="pageSizes"
          prev-text="<"
          next-text=">"
          :hide-on-single-page="true"
          :layout='["total","prev","pager","next","sizes","jumper"].join()'
          :total="total"
          :style='{"padding":"0","margin":"10px auto","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"1200px","fontWeight":"500"}'
          @current-change="curChange"
          @prev-click="prevClick"
          @next-click="nextClick"
        ></el-pagination>
    </div>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '商家商品信息'
          }
        ],
        formSearch: {
          shangpinmingcheng: '',
          pinpai: '',
          price: '',
        },
        fenlei: [],
        hotList: [],
        dataList: [],
		shangjia:{},
        total: 1,
        pageSize: 12,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        timeRange: [],
        isFixed: false,
        isFixed2:false
      }
    },
    created() {
        window.addEventListener('scroll', this.getScrollTop, true);
      this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
      this.baseUrl = this.$config.baseUrl;
      this.getFenlei();
      this.getList(1, '全部');
      this.getHotList();
    },
    //方法集合
    methods: {
      add(path) {
        this.$router.push({path: path});
      },
      getHotList() {
        let autoSortUrl = "";
        autoSortUrl = "shangpinxinxi/autoSort";
        if(localStorage.getItem('Token')) {
            autoSortUrl = "shangpinxinxi/autoSort2";
        }
          this.$http.get(autoSortUrl, {params: {
              sfsh: '是',
              page: 1,
              limit: 4,
          }}).then(res => {
              if (res.data.code == 0) {
                  this.hotList = res.data.data.list;
              }
          })
      },
      getFenlei() {
        this.$http.get('option/shangpinfenlei/shangpinfenlei').then(res => {
          if (res.data.code == 0) {
            this.fenlei = res.data.data;
          }
        });
      },
      getList(page, fenlei, ref = '') {
		if(fenlei == '全部') this.swiperIndex = -1;
		for(let i=0;i<this.fenlei.length;i++) {
			if(fenlei == this.fenlei[i]) {
				this.swiperIndex = i;
				break;
			}
		}
        this.curFenlei = fenlei;
        if (this.curFenlei == '全部') {
          this.isPlain = false;
        } else {
          this.isPlain = true;
        }
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.shangpinmingcheng != '') searchWhere.shangpinmingcheng = '%' + this.formSearch.shangpinmingcheng + '%';
        if (this.formSearch.pinpai != '') searchWhere.pinpai = '%' + this.formSearch.pinpai + '%';
        if(this.formSearch.pricestart!='' && this.formSearch.pricestart!=undefined ){
          searchWhere.pricestart = this.formSearch.pricestart
        }
        if(this.formSearch.priceend!='' && this.formSearch.priceend!=undefined){
          searchWhere.priceend = this.formSearch.priceend
        }
	      params['sfsh'] = '是';
        // if (this.curFenlei != '全部') searchWhere.shangpinfenlei = this.curFenlei;
        // this.$http.get('shangpinxinxi/list', {params: Object.assign(params, searchWhere)}).then(res => {
        //   if (res.data.code == 0) {
        //     this.dataList = res.data.data.list;
        //     this.total = res.data.data.total;
        //     this.pageSize = res.data.data.pageSize;
        //     this.totalPage = res.data.data.totalPage;
			
		// 	this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
        //   }
        // });
		params['shangjiazhanghao'] = JSON.parse(this.$route.query.detailObj).shangjiazhanghao;
		this.$http.get('shangpinxinxi/getGoodsById', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.goods;
			this.shangjia = res.data.data;
            // this.total = res.data.data.total;
            // this.pageSize = res.data.data.pageSize;
            // this.totalPage = res.data.data.totalPage;
			
			// this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });

      },
      curChange(page) {
        this.getList(page,this.curFenlei);
      },
      prevClick(page) {
        this.getList(page,this.curFenlei);
      },
      nextClick(page) {
        this.getList(page,this.curFenlei);
      },
      toDetail(item) {
        this.$router.push({path: '/index/shangpinxinxiDetail', query: {detailObj: JSON.stringify(item)}});
      },
      getScrollTop() {
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop

        if(scrollTop >= 610 )this.isFixed = true
        else this.isFixed = false
        if(scrollTop >= 680 )this.isFixed2 = true
        else this.isFixed2 = false

      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
      .fixed-style{
        position: fixed;
        top: 122px;
        left: 0;
        background: #fff !important;
        z-index: 9999;
        padding-top: 10px !important;
      }
      .fixed-style2{
        position: fixed;
        top: 186px;
        left: 0;
        z-index: 9999;
        margin-top: 0 !important;
      }
	.list-preview .list-form-pv .el-input {
		width: auto;
	}

    .mouse-cover-canvas {
      position: absolute;
      left: 635px !important;
      top: 780px !important;
      width: 500px !important;
      top: 600px !important;
    }

	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #666;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
		color: #333;
		display: inline-block;
	}
	
	.category-1 .item {
		cursor: pointer;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0 10px 10px 0;
		color: #333;
		background: linear-gradient(30deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c;
		width: auto;
		font-size: 15px;
		line-height: 44px;
		text-align: center;
		min-width: 110px;
		height: 44px;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border-radius: 30px;
		margin: 0 10px 10px 0;
		color: #fff;
		background: linear-gradient(140deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c;
		width: auto;
		font-size: 15px;
		line-height: 44px;
		text-align: center;
		min-width: 110px;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		border-radius: 30px;
		margin: 0 10px 10px 0;
		color: #fff;
		background: linear-gradient(140deg, rgba(255,255,255,1) 0%, rgba(207,193,176,1) 20%, rgba(166,147,124,1) 50%, rgba(207,193,176,1) 80%, rgba(255,255,255,1) 100%),#a6937c;
		width: auto;
		font-size: 15px;
		line-height: 44px;
		text-align: center;
		min-width: 110px;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #666;
		width: 140px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #666;
		width: 120px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #eee;
		border-radius: 30px;
		padding: 0 30px;
		margin: 0;
		outline: none;
		color: #666;
		width: 120px;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		transform: translate3d(0px, 10px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		transform: skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		-webkit-perspective: 1000px;
		perspective: 1000px;
		transition: 0.3s;
	}
	
	.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #409EFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #936837;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #936837;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}
	
	.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
</style>
