<script setup>
import { ref, onMounted } from "vue";
import AdminUserItem from "@/components/admin/items/AdminUserItem.vue";
import { getUserList } from "@/api/admin";
// Data
const props = defineProps({ user: Object });

const userList = ref([]);
onMounted(async () => {
  const response = await getUserList();
  userList.value = response.data;
});
</script>

<template>
  <div class="user-list-title"><h1>유저 목록</h1></div>
  <div class="user-list">
    <table class="table table-hover">
      <thead>
        <tr class="text-center">
          <th scope="col">사용자 ID</th>
          <th scope="col">닉네임</th>
          <th scope="col">공개동의여부</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <AdminUserItem
          v-for="user in userList"
          :key="user.userId"
          :user="user"
        ></AdminUserItem>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}
.user-list {
  border: 1px solid black;
  width: 87%;
  height: 85%;
}
</style>
