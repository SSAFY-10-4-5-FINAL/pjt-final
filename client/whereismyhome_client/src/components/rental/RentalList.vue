<script setup>
import { ref, onMounted } from "vue";
import { listRentalBoardBySearch } from "@/api/rental.js";
import RentalListItem from "./item/RentalListItem.vue";

onMounted(() => {
  getRentalBoardList();
});

// Data
const rentalList = ref([]);
const searchInput = ref("");

// Function
const getRentalBoardList = async () => {
  const response = await listRentalBoardBySearch(searchInput.value);
  rentalList.value = response.data;
  console.log(rentalList.value);
};
</script>

<template>
  <div class="container-fluid">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 text-center">단기 양도 게시판</h2>
      </div>
      <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <RouterLink :to="{ name: 'RentalWrite' }"
              ><button type="button" class="btn btn-sm">글쓰기</button></RouterLink
            >
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm ms-1">
                <input
                  type="text"
                  class="form-control"
                  placeholder="검색어..."
                  v-model="searchInput" />
                <button class="btn btn-dark" type="button" @click="getRentalBoardList">검색</button>
              </div>
            </form>
          </div>
        </div>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>

          <tbody>
            <RentalListItem
              v-for="(b, index) in rentalList"
              :key="b.articleNo"
              :index="index"
              :rentalboard="b"></RentalListItem>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
