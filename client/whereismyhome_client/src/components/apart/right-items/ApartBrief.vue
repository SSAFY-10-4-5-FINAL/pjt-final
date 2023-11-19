<script setup>
import { ref } from "vue";

// Data
const apartName = ref("테스트1");
const apartAddress = ref("메시 호드리구 규동");
const apartDealAmount = ref(10000000);
</script>
<template>
  <div id="apart-brief-wrap">
    <h4>{{ apartName }}</h4>
    <p>{{ apartAddress }}</p>
    <p>{{ apartDealAmount }}</p>
  </div>
</template>
<style scoped>
#apart-brief-wrap {
  height: 125px;
  border: 1px solid #708090;
  margin: 0.5px;
  padding: 4px;
}
p {
  margin-top: 20px;
}
</style>
