import Vue from 'vue'
import VueRouter from 'vue-router'
import Vuex from 'vuex'
import Routers from './router'

import 'iview/dist/styles/iview.css';
import 'bulma/css/bulma.css'
import 'font-awesome/css/font-awesome.min.css'
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
