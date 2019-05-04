import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import Routers from './router'

import 'iview/dist/styles/iview.css';
import 'bulma/css/bulma.css'
import 'font-awesome/css/font-awesome.min.css'
import Axios from 'axios';
import App from './App'

Vue.use(VueRouter);
Vue.use(Vuex);
// Vue.use(iView);

const RouterConfig = {
    mode: 'history',
    routes: Routers,
}

const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    window.document.title = to.meta.title;
    next();
});

router.afterEach((to, from, next) => {
    window.scrollTo(0, 0);
});


// 数组排重
function getFilterArray (array) {
    const res = [];
    const json = {};
    for (let i = 0; i < array.length; i++){
        const _self = array[i];
        if(!json[_self]){
            res.push(_self);
            json[_self] = 1;
        }
    }
    return res;
}

// productList中的数据如下
// private int id;
// private String type;
// private String name;
// private int price;
// private int discount;
// private String habitat;
// private String director;
// private String superStar;
// private Date date;
// private String description;

const store = new Vuex.Store({
    state: {
        productList: [],
        cartList: []
    },
    getters: {
        types: state => {
            const types = state.productList.map(item => item.type);
            return getFilterArray(types);
        },
        habitats: state => {
            const habitats = state.productList.map(item => item.habitat);
            return getFilterArray(habitats);
        }
    },
    mutations: {
        // 添加商品列表
        setProductList (state, data) {
            state.productList = data;
        },
        // 添加到购物车
        addCart (state, id) {
            // 先判断购物车是否已有，如果有，数量+1
            const isAdded = state.cartList.find(item => item.id === id);
            if (isAdded) {
                isAdded.count ++;
            } else {
                state.cartList.push({
                    id: id,
                    count: 1
                })
            }
        },
        // 修改商品数量
        editCartCount (state, payload) {
            const product = state.cartList.find(item => item.id === payload.id);
            product.count += payload.count;
        },
        // 删除商品
        deleteCart (state, id) {
            const index = state.cartList.findIndex(item => item.id === id);
            state.cartList.splice(index, 1);
        },
        // 清空购物车
        emptyCart (state) {
            state.cartList = [];
        }
    },
    actions: {
        // 请求商品列表
        getProductList (context) {
            Axios({
                method: 'get',
                url: '/product/query/all',
                baseURL: 'http://localhost:8082',
            }).then(response=> {
                console.log(response)
                context.commit('setProductList', response.data)
            }).catch(error=>{
                console.warn(error)
                alert(error)
            })
        },
        // 购买
        buy (context) {
            // 真实环境应通过 ajax 提交购买请求后再清空购物列表
            return new Promise(resolve=> {
                setTimeout(() => {
                    context.commit('emptyCart');
                    resolve();
                }, 500)
            });
        }
    }
});


import { Button, Modal, Icon } from 'iview'
Vue.component("Button", Button)
Vue.component("Modal", Modal)
Vue.component("Icon", Icon)

new Vue({
    el: '#app',
    router:router,
    store:store,
    template: '<App/>',
    // components: { App }
    render: h =>{ return h(App) }
})
