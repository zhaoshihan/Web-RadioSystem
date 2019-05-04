<template>
    <div class="test-modal">
        <button class="button is-danger" @click="modal2 = true">Delete</button>
        <i-modal v-model="modal2" width="360">
            <p slot="header" style="color:#f60;text-align:center">
                <Icon type="ios-information-circle"></Icon>
                <span>Delete confirmation</span>
            </p>
            <ul>
                <li v-for="(value, key, index) in instance">{{key}}: {{value}}</li>
            </ul>
            <div style="text-align:center">
                <p class="subtitle">Will you delete it?</p>
            </div>
            <div slot="footer">
                <Button type="error" size="large" long :loading="modal_loading" @click="del">Delete</Button>
            </div>
        </i-modal>
    </div>
</template>

<script>
    export default {
        props:{
            instance:Object,
        },
        data(){
            return{
                modal2: false,
                modal_loading: false,
            }
        },
        methods:{
            del () {
                this.modal_loading = true;
                setTimeout(() => {
                    this.modal_loading = false;
                    this.modal2 = false;
                    this.$Message.success('Successfully delete');
                }, 2000);
            }
        }

    }
</script>

<style scoped>

</style>
