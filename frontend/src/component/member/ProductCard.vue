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
                        <div class="level">
                            <div class="level-left level-item">
                                <detail-modal :instance="info"></detail-modal>
                            </div>
                            <div class="level-right level-item">
                                <button class="button is-success" @click.prevent="handleAddToCart">Add Cart</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    import detailModal from '../common/DetailsModal'
    export default {
        props: {
            info: Object,
        },
        components:{
          detailModal,
        },
        data () {
            return {
            }
        },
        methods: {
            // 加入购物车
            handleAddToCart () {
                this.$store.commit('addCart', this.info.id);
            }
        }
    };
</script>

<style scoped>

</style>
