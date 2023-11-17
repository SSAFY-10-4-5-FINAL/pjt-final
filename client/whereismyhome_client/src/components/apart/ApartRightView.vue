<script setup>
import { ref } from "vue";
const inputText = ref("");
</script>

<template>
  <div class="container-fluid" id="right-bar">
    <div class="search-select-wrap">
      <span id="toggle-btn-div">여기 토글버튼 들어감</span>
      <div class="search-input-liner">
        <div class="input-wrap">
          <input type="text" placeholder="아파트, 지역, 지하철역, 학교 검색" v-model="inputText" />
        </div>
        <button class="btn-clear on"></button>
        <div class="btn-search-wrap"><button class="btn-search"></button></div>
      </div>
    </div>
  </div>
</template>

<style scoped>
#toggle-div {
  height: 5px;
}
#right-bar {
  border-left: 1px solid;
  height: 100vh;
  padding: 10px;
}
.search-select-wrap {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  vertical-align: baseline;
}

#toggle-btn-div {
  /* display: block; */
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin-top: 10px;
  padding: 0;
  font: inherit;
  flex: 1 1 0%;
  overflow: hidden;
  height: 20px;
  vertical-align: top;
  box-sizing: border-box;
}

.search-input-liner {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin: 0;
  padding: 0;
  font: inherit;
  flex: 1 1 0%;
  border: 1px solid #708090;
  border-radius: 4px;
  overflow: hidden;
  height: 50px;
  vertical-align: top;
  box-sizing: border-box;
}
.input-wrap {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin: 0;
  border: 0;
  font: inherit;
  vertical-align: baseline;
  float: left;
  width: 285px;
  padding: 0px 10px;
  position: relative;
  overflow: hidden;
}

input {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  width: 100%;
  height: 50px;
  border: none;
  appearance: none;
  outline: none;
  box-shadow: none;
  font-size: 13px;
}

.btn-clear {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  font-family: "SpoqaHanSans";
  padding: 0px;
  border: 0px;
  margin: 0px;
  vertical-align: middle;
  cursor: pointer;
  position: absolute;
  display: none;
  width: 50px;
  height: 50px;
  background: url("https://s.zigbang.com/www/images/ic_searchbar_close_20x20_nor_black_slim.png")
    center center / 20px 20px no-repeat transparent;
}

.btn-search-wrap {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  vertical-align: baseline;
  float: right;
  background-color: #708090;
  width: 50px;
  height: 50px;
  overflow: hidden;
}

.btn-search {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  font-family: "SpoqaHanSans";
  padding: 0px;
  border: 0px;
  margin: 0px;
  vertical-align: middle;
  cursor: pointer;
  width: 50px;
  height: 50px;
  background: url("https://s.zigbang.com/www/images/ic_title_searchbar_30x30_nor_white.png") center
    center / 100% no-repeat transparent;
}
</style>
