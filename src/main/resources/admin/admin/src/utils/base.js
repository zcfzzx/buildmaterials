const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootq4h82/",
            name: "springbootq4h82",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootq4h82/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "装修建材商城"
        } 
    }
}
export default base
