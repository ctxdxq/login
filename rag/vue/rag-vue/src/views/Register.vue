<template>
  <div style="width: 100%; height: 100vh; background-color: cornflowerblue; overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <div style="color: #cccccc; font-size: 30px; text-align: center; padding: 30px 0">欢迎注册</div>
      <el-form :model="form" label-width="auto" style="max-width: 600px" size="normal" :rules="rules" ref="form">
        <el-form-item prop="username">
          <el-input v-model="form.name" :prefix-icon="User" placeholder="请输入账号"/>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" :prefix-icon="Lock" placeholder="请输入密码" show-password/>
        </el-form-item>
        <el-form-item prop="confirm">
          <el-input v-model="form.confirm" :prefix-icon="Lock" placeholder="再次输入密码" show-password/>
        </el-form-item>
<!--        <el-form-item>-->
<!--          <el-button style="width: 100%" type="primary" @click="login">登 录</el-button>-->
<!--        </el-form-item>-->
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="register">注 册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {Lock, User} from "@element-plus/icons";
import request from "@/utils/request";

export default {
  name: "Register",
  computed: {
    Lock() {
      return Lock
    },
    User() {
      return User
    }
  },
  methods: {
    register() {
      if(this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: "两次密码输入不一致"
        })
        return
      }

      request.post("/user/register", this.form).then(res => {
        if(res.code == '0'){
          this.$message({
            type: "success",
            message: "注册成功"
          })
          this.$router.push("/Login")
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    }
  },
  data() {
    return{
      form: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        confirm: [
          { required: true, message: '请确认密码', trigger: 'blur' },
        ],
      }
    }
  }
}
</script>

<style scoped>

</style>