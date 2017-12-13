 <div class="container">

<div class="row">
  <!-- Would be to display sidebar -->
  <div class="col-md-3">
      
  <%@include file="./shared/sidebar.jsp" %>
  
  </div>
  <!-- to display the actual products -->
  <div class="col-md-9">
    
    <!-- Added breadcrumb component -->
    <div class="row">
      <div class="col-lg-12">
      
      <c:if test="${userClickAllProducts==true}">
      
      <script>
        window.categoryId='';
      </script>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
        <li  class="breadcrumb-item"><a class="active">All Products</a></li>
      </ol>
      </c:if>
      
       <c:if test="${userClickCategoryProducts==true}">
       <script>
        window.categoryId='${category.id}';
      </script>
      
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
        <li class="breadcrumb-item"><a class="active">Category</a></li>
        <li class="breadcrumb-item"><a class="active">${category.name}</a></li>
      </ol>
      </c:if>
      </div>
    
    
    </div>
  
    <div class="row">
          <div class="col-xs-12">
          
          <div class="container-fluid">
             <div class="table-responsive">
                <table id="productListTable" class="table-striped table-borderd">
               <thead>
                  <tr>
                  <th></th>
                  <th>Name</th>
                  <th>Brand</th>
                  <th>Price</th>
                  <th>Qty.Available</th>
                  <th></th>
                  </tr>               
               </thead>
               
              <tfoot>
                  <tr>
                  <th></th>
                  <th>Name</th>
                  <th>Brand</th>
                  <th>Price</th>
                  <th>Qty.Available</th>
                  <th></th>
                  </tr>
               </tfoot>
            
            </table>
             </div>
          
          </div>
          
           
            
          </div>
                
    </div>
  </div>

</div>



</div>