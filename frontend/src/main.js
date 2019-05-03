import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
// import iView from 'iview'
import 'iview/dist/styles/iview.css';
import 'bulma/css/bulma.css'
import 'font-awesome/css/font-awesome.min.css'
import App from './App'

Vue.use(VueRouter);
Vue.use(Vuex);
// Vue.use(iView);

const routes = [
    {
        path: '/',
        redirect: '/staff_home'
    },
    {
        path: '/login',
        meta: {
            title: '登录'
        },
        component: (resolve) => require(['./page/Login.vue'], resolve)
    },
    {
        path:'/register_staff',
        meta:{
            title: '职员注册'
        },
        component: (resolve) => require(['./page/RegisterStaff.vue'], resolve)
    },
    {
        path:'/register_member',
        meta:{
            title: '会员注册'
        },
        component: (resolve) => require(['./page/RegisterMember.vue'], resolve)
    },
    {
        path: '/staff_home',
        meta: {
            title: '职员首页'
        },
        component: (resolve) => require(['./page/StaffHome.vue'], resolve)
    },
    {
        path: '/staff_home',
        meta: {
            title: '会员首页'
        },
        // component: (resolve) => require(['./page/.vue'], resolve)
    },
    // {
    //     path: '*',
    //     redirect: '/login'
    // },
]

const RouterConfig = {
    mode: 'history',
    routes: routes,
    linkActiveClass: "is-active"
}

const router = new VueRouter(RouterConfig);

router.beforeEach((to, from, next) => {
    window.document.title = to.meta.title;
    next();
});

router.afterEach((to, from, next) => {
    window.scrollTo(0, 0);
});


const store = new Vuex.Store({

})

import { Button, Modal } from 'iview'
Vue.component("Button", Button)
Vue.component("Modal", Modal)

new Vue({
    el: '#app',
    router,
    store:store,
    template: '<App/>',
    // components: { App }
    render: h =>{ return h(App) }
})
