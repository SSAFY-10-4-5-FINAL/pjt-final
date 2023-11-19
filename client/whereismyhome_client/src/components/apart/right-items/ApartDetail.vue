<script setup>
import { ref } from "vue";

// Data
const apartName = ref("테스트 아파트");
</script>
<template>
  <div id="detail-wrap">
    <h2>{{ apartName }}</h2>
  </div>
</template>
<style scoped>
#detail-wrap {
  height: 125px;
  border: 1px solid #708090;
  margin: 0.5px;
  padding: 4px;
}
</style>
