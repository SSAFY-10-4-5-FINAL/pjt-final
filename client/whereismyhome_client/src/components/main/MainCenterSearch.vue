<script setup></script>

<template>
  <div class="search-input-liner">
    <div class="input-wrap">
      <input type="text" placeholder="지역, 아파트 검색" />
    </div>
    <div class="btn-search-wrap">
      <router-link :to="{ name: 'ApartView' }"
        ><button class="btn-search"></button
      ></router-link>
    </div>
  </div>
</template>

<style scoped>
/* input part */
.search-input-liner {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  text-size-adjust: none;
  -webkit-box-direction: normal;
  margin-bottom: 10px;
  padding: 0;
  font: inherit;
  border-radius: 4px;
  overflow: hidden;
  height: 50px;
  vertical-align: top;
  box-sizing: border-box;
  position: relative;
  background-color: white;
  top: 10px;
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
  padding: 0px 5px;
  position: relative;
  overflow: hidden;

  width: 80%;
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
  background-color: rgb(231, 231, 97);
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
  background: url("https://s.zigbang.com/www/images/ic_title_searchbar_30x30_nor_white.png")
    center center / 100% no-repeat transparent;
}
</style>
