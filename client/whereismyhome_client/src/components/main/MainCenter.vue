<script setup>
import MainCenterSearch from "./MainCenterSearch.vue";
</script>
<template>
  <div class="main-center-wrap">
    <div class="ask-wrap">
      <div class="ask-text">어떤 집을 찾고 계세요?</div>
      <div class="search-wrap"><MainCenterSearch /></div>
    </div>
  </div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap");

.main-center-wrap {
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  width: 100%;
  height: 550px;
  /* background-image: url(../../assets/img/bg_test_2.jpg); */
  background-color: grey;
}

.ask-wrap {
  margin-top: 150px;
}

.ask-text {
  font-family: "Noto Sans KR", sans-serif;
  font-size: 48px;
  text-align: center;
  color: white;
}

.search-wrap {
  width: 600px;
}
</style>
