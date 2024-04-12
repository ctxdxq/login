<template>
  <div style="height: 50px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="width: 250px; padding-left: 30px; font-weight: bold; color: cornflowerblue">基于RAG的智能问答系统</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
        <el-dropdown style="vertical-align: middle">
          <span class="el-dropdown-link">
            用户
            <el-icon class="el-icon--right">
              <arrow-down/>
            </el-icon>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>修改密码</el-dropdown-item>
              <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
    </div>

  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>
