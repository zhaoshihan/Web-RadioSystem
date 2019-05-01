import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import App from './App'

Vue.use(VueRouter);
Vue.use(Vuex);

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        meta: {
            title: '登录'
        },
        component: (resolve) => require(['./page/Login.vue'], resolve)
    },
    {
        path: '/staff_home',
        meta: {
            title: '职员首页'
        },
        component: (resolve) => require(['./page/StaffHome.vue'], resolve)
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


new Vue({
    el: '#app',
    router,
    store:store,
    template: '<App/>',
    // components: { App }
    render: h =>{ return h(App) }
})
