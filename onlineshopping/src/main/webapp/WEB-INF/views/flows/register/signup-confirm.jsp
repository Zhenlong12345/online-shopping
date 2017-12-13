<%@include file="../shared/flows-header.jsp" %>
     <div class="container">

     	<div class="row">
	
		<div class="col-sm-6">
	
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
			
				<div class="panel-body">
 					<div class="text-center">
						<h3>Name : <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></h3>
						<h4>Email : <strong>${registerModel.user.email}</strong></h4>
						<h4>Contact : <strong>${registerModel.user.contactNumber}</strong></h4>
						<h4>Role : <strong>${registerModel.user.role}</strong></h4>
<%-- 						<p>
							<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
						</p> --%>
					</div> 
				</div>
			   <div class="panel-footer">
			     <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-lg btn-primary">Edit</a>
			   </div>
			</div>
					
		
		</div>
		
		<div class="col-sm-6">
		
			<div class="panel panel-primary">
				
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
			
				<div class="panel-body">
 					<div class="text-center">
						<p>${registerModel.billingAddress.addressLineOne}, </p>
						<p>${registerModel.billingAddress.addressLineTwo}, </p>
						<p>${registerModel.billingAddress.city} -  ${registerModel.billingAddress.postalCode}, </p>
						<p>${registerModel.billingAddress.state}</p>
						<p>${registerModel.billingAddress.country}</p>
<%-- 						<p>
							<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
						</p> --%>
					</div> 
				</div>
				
				<div class="panel-footer">
				<!-- anchor to move to the edit of address -->
				<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-lg btn-primary">Edit</a>
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

     </div>
   
<%@include file="../shared/flows-footer.jsp"%>