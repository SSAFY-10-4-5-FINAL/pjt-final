<script setup>
import { ref, onMounted } from "vue";
import { listApart } from "@/api/apart.js";
import ApartBrief from "./ApartBrief.vue";

onMounted(() => {
  getApartList();
});

const dongCode = ref({
  dongCode: ref("1114016200"),
});

// Data
const apartList = ref([]);

// Function
const getApartList = async () => {
  console.log("서버에서 아파트목록 얻어오자!!!", dongCode.value);

  const response = await listApart(dongCode.value);
  apartList.value = response.data;
  console.log(apartList.value);
};
</script>
<template>
  <ApartBrief
    v-for="(apart, index) in apartList"
    :key="apart.aptCode"
    :index="index"
    :apart="apart" />
</template>
<style scoped></style>
