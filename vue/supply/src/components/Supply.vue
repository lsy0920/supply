<template>
  <div class="find">
    <el-form :inline="true" class="search">
      <el-form-item label="物料编码">
        <el-autocomplete
          v-model="searchSupplyNumber"
          :fetch-suggestions="getListNumber"
          placeholder = ""
          clearable
          @select="handleSelect"
          suffix-icon="el-icon-search"
        ></el-autocomplete>
      </el-form-item>
      <el-form-item label="物料名称">
        <!-- <el-input 
            v-model="supplyName" 
            class="search_name" 
            placeholder=""
            suffix-icon="el-icon-search">   
        </el-input>-->
        <el-autocomplete
          v-model="searchSupplyName"
          :fetch-suggestions="getListName"
          placeholder = ""
          clearable
          @select="handleSelectName"
          suffix-icon="el-icon-search"
        ></el-autocomplete>
      </el-form-item>
      <el-form-item label="下达时间从">
        <el-date-picker
          class="dateWidth"
          v-model="searchSupplyTimeFrom"
          type="date"
          placeholder = ""
          value-format="yyyy-MM-dd"
        ></el-date-picker>
        <!-- :picker-options="dateFrom" -->
      </el-form-item>
      <el-form-item label="下达时间至">
        <el-date-picker
          class="dateWidth"
          v-model="searchSupplyTimeTo"
          type="date"
          placeholder = ""
          value-format="yyyy-MM-dd"
        ></el-date-picker>
        <!-- :picker-options="dateTo" -->
      </el-form-item>
    </el-form>
    <div class="button">
      <el-button type="info" @click="getSupplyList">查询</el-button>
      <el-button type="info" @click="clear">清除</el-button>
    </div>
    <div class="table">
      <!-- <el-table :data="supplyData" border style="width: 100%">
        <el-table-column prop="supplyNumber" label="物料编码" width="212"></el-table-column>
        <el-table-column prop="supplyName" label="物料名称" width="220"></el-table-column>
        <el-table-column prop="releaseTime" label="下达时间" width="220"></el-table-column>
      </el-table> -->
      <el-table :data="supplyData" border style="width: 100%">
        <el-table-column prop="supplyNumber" label="物料编码"></el-table-column>
        <el-table-column prop="supplyName" label="物料名称"></el-table-column>
        <el-table-column prop="releaseTime" label="下达时间"></el-table-column>
      </el-table>
    </div>
    <div class="page">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5,10,15,20]"
        :page-size="pageSize"
        layout="total,sizes,prev,pager,next,jumper"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  name: "Supply",
  data() {
    return {
      // timeRange: [],
      supplyData: [],
      searchSupplyNumber: "",
      searchSupplyName: "",
      // searchSupplyTime: "",
      searchSupplyTimeFrom: "",
      searchSupplyTimeTo: "",
      pageSize: 5,
      currentPage: 1,
      total: 0,
    };
  },
  mounted() {
    this.getPage();
  
  },
  methods: {
    handleSelect(item) {
      console.log(item);
    },
    
  
    getListNumber(queryString, cb) {
     this.$http({
       method: "post",
       url: "/api/findByNumber",
        params: {
          supplyNumber: queryString,
        }
     })
     .then(response =>{
      //  console.log("--");
      //  console.log(response.data.length);
      //  console.log("--");
       for(var i=0; i<response.data.length; i++) {
          response.data[i].value = response.data[i].supplyNumber;
       }
       cb(response.data);
     })
    },

    getListName(queryString, cb) {
     this.$http({
       method: "post",
       url: "/api/findByName",
        params: {
          supplyName: queryString,
        }
     })
     .then(response =>{
      //  console.log("--");
      //  console.log(response.data.length);
      //  console.log("--");
       for(var i=0; i<response.data.length; i++) {
          response.data[i].value = response.data[i].supplyName;
       }
       cb(response.data);
     })
    },
    
    handleSelectName(item) {
      console.log(item);
    },

    getSupplyList() {
      console.log(this.searchSupplyTimeTo);
      console.log(this.searchSupplyTimeFrom);
      this.$http({
        method: "post",
        url: "/api/findAllList",
        params: {
          supplyNumber: this.searchSupplyNumber,
          supplyName: this.searchSupplyName,
          searchSupplyTimeFrom: this.searchSupplyTimeFrom,
          searchSupplyTimeTo: this.searchSupplyTimeTo,
          releaseTime: this.releaseTime,
          currentPage: this.currentPage,
          pageSize: this.pageSize
        }
      })
        .then(response => {
          // if(this.searchSupplyNumber != null && this.searchSupplyNumber != '') {
          //   this.supplyNumber = response.data.supplyNumber; 
          // };
          // if(this.searchSupplyName != null && this.searchSupplyName != '') {
          //   this.supplyName = response.data.supplyName; 
          // };
          // if(this.searchSupplyTimeFrom != null && this.searchSupplyTimeFrom != '') {
          //   if(this.searchSupplyTimeTo != null && this.searchSupplyTimeTo != '') {
          //     this.releaseTime = response.data.releaseTime;
          //   };
          // };
           this.supplyNumber = response.data.supplyNumber; 
           this.supplyName = response.data.supplyName;
            this.releaseTime = response.data.releaseTime; 
          console.log(response.data);
          this.supplyData = response.data.records;
          this.total = response.data.total;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
   
    // getSupplyList() {
       
    //   this.$http({
    //     method: "post",
    //     url: "/api/findAllList",
    //     params: {
    //       supplyNumber: this.searchSupplyNumber,
    //       supplyName: this.searchSupplyName,
    //       // releaseTime: this.searchSupplyTime,
    //       currentPage: this.currentPage,
    //       pageSize: this.pageSize
    //     }
    //   })
    //     .then(response => {
    //       console.log(response.data);
    //       this.supplyData = response.data.records;
    //       this.total = response.data.total;
    //     })
    //     .catch(function(error) {
    //       console.log(error);
    //     });
    // },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
      this.getPage();
      this.getSupplyList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;

      console.log(this.currentPage + " " + this.pageSize);
      this.getPage();
      this.getSupplyList();
    },
    getPage() {
      this.$http({
        method: "post",
        url: "/api/supplyTable",
        params: {
          currentPage: this.currentPage,
          pageSize: this.pageSize,
          // supplyNumber: this.supplyNumber,
          // supplyName: this.supplyName,
          // releaseTime: this.releaseTime
        }
      })
      .then(response => {
        console.log(response.data);
        this.supplyData = response.data.records;
        this.total = response.data.total;
        console.log(this.total);
      })
      .catch(function(error) {
        console.log(error);
      });
    },
    clear() {
      this.searchSupplyNumber = "";
      this.searchSupplyName = "";
      // this.searchSupplyTime = "";
      this.searchSupplyTimeFrom = "";
      this.searchSupplyTimeTo = "";
      //  location.reload();
      this.getPage();
    }
  }
};
</script>

<style scoped>
/* .search {
  margin-right: 55%;
} */
.button {
  margin-right: 56%;
}
.table {
  margin-left: 350px;
  margin-top: 20px;
  margin-right: 350px;
}
.page {
  margin-top: 20px;
}
</style>

