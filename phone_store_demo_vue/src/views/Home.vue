<template>
  <div>
    <van-row>
      <van-col span="24">
        <van-tabs @click="onClick" sticky title-active-color="#E32DAB" color="#E32DAB" :line-width="100" :line-height="2">

          <van-tab v-for="index in categories.length" :title="categories[index-1].name" class="tab">

            <van-card v-for="(item,index) in phones"
                      :price="item.price"
                      :desc="item.desc"
                      :title="item.title"
                      :thumb="item.thumb"
            >
              <template #tags>
                <van-tag v-for="tag in item.tag" color="#f2826a" style="margin-left: 5px;">{{tag.name}}</van-tag>
              </template>
              <template #footer>
                <van-button round type="info" size="mini" @click="buy(index)">购买</van-button>
              </template>
            </van-card>
          </van-tab>
        </van-tabs>
      </van-col>
    </van-row>
    <van-sku
            v-model="show"
            :sku="sku"
            :goods="goods"
            :hide-stock="sku.hide_stock"
            @buy-clicked="onBuyClicked"
    >
      <template #sku-actions="props">
        <div class="van-sku-actions">

          <!-- 直接触发 sku 内部事件，通过内部事件执行 onBuyClicked 回调 -->
          <van-button
                  square
                  size="large"
                  type="danger"
                  @click="props.skuEventBus.$emit('sku:buy')"
          >
            买买买
          </van-button>
        </div>
      </template>
    </van-sku>

  </div>


</template>

<script>
  import {
    Toast,
    PullRefresh,
    Swipe,
    SwipeItem
  } from 'vant';
  export default {
    comments:{
      [PullRefresh.name]: PullRefresh,
      [Swipe.name]: Swipe,
      [SwipeItem.name]: SwipeItem
    },
    data() {
      return {
        categories: "",
        phones: "",
        show: false,
        goods: "",
        sku: {
          tree: [
            {
              k: "规格",
              v: [
                {
                  id: 1,
                  name: "32GB",
                  imgUrl: "../static/21cdb981-61f2-433e-84b6-8de2ed1a3bfd.jpg",
                  previewImgUrl: "../static/21cdb981-61f2-433e-84b6-8de2ed1a3bfd.jpg"
                },
                {
                  id: 2,
                  name: "64GB",
                  imgUrl: "../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg",
                  previewImgUrl: "../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg"
                }
              ],
              k_s: "s1"
            }
          ],
          list: [
            {
              s1: 1,
              price: 280000,
              stock_num: 34
            },
            {
              s1: 2,
              price: 320000,
              stock_num: 1
            }
          ],
          price: "2800.00",
          stock_num: 2,
          none_sku: false,
          hide_stock: false
        }
      }
    },
    created(){
      const _this = this
      axios.get("http://localhost:8181/phone/index").then(function (resp){
        _this.phones = resp.data.data.phones
        _this.categories = resp.data.data.categories
      })
    },
    methods: {
      onClick(index) {
        const _this = this
        axios.get("http://localhost:8181/phone/findByCategoryType/"+this.categories[index].type).then(function (resp){
          _this.phones = resp.data.data
        })
      },
        buy(index){
          this.show = true
          // alert(this.phones[index].id)
          const _this = this
          axios.get("http://localhost:8181/phone/findSpecsByPhoneId/"+this.phones[index].id).then(function (resp){
            _this.goods = resp.data.data.goods
            _this.sku = resp.data.data.sku
          })
        },
        onBuyClicked(item){
          this.$store.state.specsId = item.selectedSkuComb.s1
          this.$store.state.quantity = item.selectedNum
          this.$router.push('/addressList')
        }
    }
  }
</script>