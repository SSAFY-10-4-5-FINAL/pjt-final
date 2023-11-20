<script setup>
import MainUnderLeft from "./under-items/MainUnderLeft.vue";
import MainUnderRight from "./under-items/MainUnderRight.vue";
</script>

<template>
  <div class="under-wrap"><MainUnderLeft /><MainUnderRight /></div>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap");
.under-wrap {
  font-family: "Noto Sans KR", sans-serif;
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  height: 350px;
}
</style>
