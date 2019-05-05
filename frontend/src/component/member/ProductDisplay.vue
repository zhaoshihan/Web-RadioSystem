<template>
    <div class="product-display">
        <div class="list-control">
            <div class="field">
                <div class="tags are-medium">
                    <span class="tag is-white">Type：</span>
                    <a
                            class="tag"
                            :class="{on: item === filterTypes}"
                            v-for="item in types"
                            @click="handleFilterTypes(item)">{{ item }}</a>
                </div>
            </div>
            <div class="field">
                <div class="tags are-medium">
                    <span class="tag is-white">Country：</span>
                    <a
                            class="tag"
                            :class="{on: item === filterHabitats}"
                            v-for="item in habitats"
                            @click="handleFilterHabitats(item)">{{ item }}</a>
                </div>
            </div>
            <div class="field">
                <div class="tags are-medium">
                    <span class="tag is-white">Order：</span>
                    <a
                            class="tag"
                            :class="{on: order === ''}"
                            @click="handleOrderDefault">Default</a>
                    <a
                            class="tag"
                            :class="{on: order.indexOf('cost') > -1}"
                            @click="handleOrderCost">
                        Price
                        <template v-if="order === 'cost-asc'">↑</template>
                        <template v-if="order === 'cost-desc'">↓</template>
                    </a>
                </div>
            </div>
        </div>
        <div class="selection">
            <div class="row columns is-multiline">
                <product-card v-for="item in filteredAndOrderedList" :info="item" :key="item.id"></product-card>
            </div>
        </div>
    </div>
</template>

<script>
    import ProductCard from './ProductCard'
    export default {
        mounted () {
            this.$store.dispatch('getProductList');
        },
        components: { ProductCard },
        computed: {
            productList(){
                return this.$store.state.member.productList;
            },
            types () {
                return this.$store.getters.types;
            },
            habitats () {
                return this.$store.getters.habitats;
            },
            filteredAndOrderedList () {
                let list = [...this.productList];
                // 按类型过滤
                if (this.filterTypes !== '') {
                    list = list.filter(item => item.type === this.filterTypes);
                }
                // 按国家过滤
                if (this.filterHabitats !== '') {
                    list = list.filter(item => item.habitat === this.filterHabitats);
                }
                // 排序
                if (this.order !== '') {
                    if (this.order === 'cost-desc') {
                        list = list.sort((a, b) => b.price - a.price);
                    } else if (this.order === 'cost-asc') {
                        list = list.sort((a, b) => a.price - b.price);
                    }
                }
                return list;
            }
        },
        data () {
            return {
                filterTypes: '',
                filterHabitats: '',
                order: ''
            }
        },
        methods: {
            handleFilterTypes (type) {
                if (this.filterTypes === type) {
                    this.filterTypes = '';
                } else {
                    this.filterTypes = type;
                }
            },
            handleFilterHabitats (habitat) {
                if (this.filterHabitats === habitat) {
                    this.filterHabitats = '';
                } else {
                    this.filterHabitats = habitat;
                }
            },
            handleOrderDefault () {
                this.order = '';
            },
            handleOrderCost () {
                if (this.order === 'cost-desc') {
                    this.order = 'cost-asc';
                } else {
                    this.order = 'cost-desc';
                }
            }
        },
    }
</script>

<style scoped>
    .tag.on{
        background: #f2352e;
        border: 1px solid #f2352e;
        color: #fff;
    }
</style>
