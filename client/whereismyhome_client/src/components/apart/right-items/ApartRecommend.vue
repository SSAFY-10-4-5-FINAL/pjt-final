<script setup>
import { ref, onMounted } from "vue";
import { listApart, listApart2 } from "@/api/apart.js";
import ApartBrief from "./ApartBrief.vue";

onMounted(() => {
  getApartList();
});

const dongCode = ref({
  dongCode: ref("1111011500"),
});

// Data
const apartList = ref([]);

// Function
const getApartList = async () => {
  console.log("서버에서 아파트목록 얻어오자!!!", dongCode.value);

  const response = await listApart2(dongCode.value);
  console.log(response);

  // fetch("http://localhost:8080/apart?dongCode=1111011500")
  //   .then((response) => response.json())
  //   .then((data) => console.log(data));
};

const test_count = ref(5);
</script>
<template>
  <ApartBrief v-for="() in test_count" />
</template>
<style scoped></style>
