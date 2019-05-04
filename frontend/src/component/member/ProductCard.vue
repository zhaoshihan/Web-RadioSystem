<template>
    <div class="column is-one-third">
        <div class="card">
            <div class="card-image">
                <figure class="image is-4by3">
                    <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Image">
                </figure>
            </div>
            <div class="card-content">
                <ul style="list-style:none">
                    <li class="title is-4">{{info.name}}</li>
                    <li class="subtitle is-6">¥ {{info.price}}</li>
                    <li class="subtitle is-6">{{info.type}}</li>
                    <li class="subtitle is-6">{{info.habitat}}</li>
                    <li>
                        <a class="button is-success" @click.prevent="handleCart">加入购物车</a>

                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        props: {
            info: Object
        },
        data () {
            return {
                colors: {
                    '白色': '#ffffff',
                    '金色': '#dac272',
                    '蓝色': '#233472',
                    '红色': '#f2352e'
                }
            }
        },
        methods: {
            handleCart () {
                this.$store.commit('addCart', this.info.id);
            }
        }
    };
</script>

<style scoped>

</style>
