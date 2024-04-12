<template>
  <div style="padding: 10px">
<!--    功能区域-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
<!--    搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" style="width: 20%" placeholder="请输入关键字" clearable/>
      <el-button type="primary" style="margin-left: 10px" @click="load">查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%" >
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="name" label="用户名" />
      <el-table-column prop="password" label="密码" />
      <el-table-column fixed="right" label="Operations" width="200">
        <template #default="scope">
          <el-button link type="primary">编辑</el-button>
          <el-popconfirm title="确认删除吗？">
            <template #reference>
              <el-button link type="primary" >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 10px 0">
      <el-pagination
          v-model:current-page="currentPage4"
          v-model:page-size="pageSize4"
          :page-sizes="[5, 10, 15]"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>

<!--    <el-dialog-->
<!--        v-model="dialogVisible"-->
<!--        title="新增用户"-->
<!--        width="500">-->
<!--      <el-form model="form" label-width="120px">-->
<!--        <el-form-item label="用户名">-->
<!--          <el-input v-model="form.username" style="width: 80%"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="昵称">-->
<!--          <el-input v-model="form.nickname" style="width: 80%"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="年龄">-->
<!--          <el-input v-model="form.age" style="width: 80%"/>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="性别">-->
<!--          <el-radio-group v-model="form.sex" class="ml-4">-->
<!--            <el-radio value="1" size="large">男</el-radio>-->
<!--            <el-radio value="2" size="large">女</el-radio>-->
<!--            <el-radio value="3" size="large">未知</el-radio>-->
<!--          </el-radio-group>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="地址">-->
<!--          <el-input type="textarea" v-model="form.address" style="width: 80%"/>-->
<!--        </el-form-item>-->

<!--      </el-form>-->
<!--      <template #footer>-->
<!--        <div class="dialog-footer">-->
<!--          <el-button @click="dialogVisible = false">取消</el-button>-->
<!--          <el-button type="primary" @click="save">确定</el-button>-->
<!--        </div>-->
<!--      </template>-->
<!--    </el-dialog>-->

  </div>
</template>

<script>

import request from "@/utils/request";
import {getCurrentScope} from "vue";

export default {
  name: 'HomeView',
  components: {

  },
  data() {
    return {
      form: {},
      dialogVisible: false,
      search:'',
      currentPage4: 1,
      pageSize4: 10,
      total: 10,
      tableData: [

      ]
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {

    },
    add() {
      this.dialogVisible = true;
      this.form = {};
    },
    save() {

    },
    handleSizeChange() {   //改变当前每页的个数触发

    },
    handleCurrentChange() {   //改变当前页码触发

    },
  }
}

</script>
