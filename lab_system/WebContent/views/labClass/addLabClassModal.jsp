<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 模态框（Modal） -->
<div class="modal fade" id="addLabClassModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
     <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">新增实验室</h4>
             </div>
      
      <div id="modalBody" class="modal-body">
        <div class="form-group row">
          <div class="col-md-4">
             <label class="control-label" for="name">
                实验室名字：
             </label>   
          </div>
          <div class="col-md-8">
              <input id="name" type="text" class="form-control col-md-8" placeholder="请输入实验室名字：">
          </div>
          
        </div>        
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="addReturn">取消</button>
        <button type="button" class="btn btn-primary" id="addSubmit">保存</button>
      </div>
    
    </div>
  </div>
</div>