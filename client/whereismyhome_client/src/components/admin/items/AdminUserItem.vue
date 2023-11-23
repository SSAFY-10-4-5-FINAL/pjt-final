<script setup>
import { deleteUser } from "@/api/admin";
// Data
const props = defineProps({ user: Object });

//
async function onDeleteUser() {
  const response = await deleteUser(props.user.loginId);
  let msg = "회원이 삭제되었습니다.";
  alert(msg);
  router.push({ name: "MainView" }).then(() => {
    router.push({ name: "AdminView" });
  });
}
</script>

<template>
  <tr class="text-center">
    <th scope="row">
      <router-link
        :to="{ name: 'AdminUserDetail', params: { loginId: user.loginId } }"
        style="text-decoration: none; color: inherit"
        >{{ user.loginId }}</router-link
      >
    </th>

    <td class="">
      {{ user.nickname }}
    </td>
    <td>{{ user.openAgreement }}</td>
    <td><button @click="onDeleteUser">회원 삭제</button></td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
