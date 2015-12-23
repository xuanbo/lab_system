<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 模态框（Modal） -->
<div class="modal fade" id="pulsModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" data-id="">
    <div class="modal-dialog">
     <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">增加器材数目</h4>
             </div>
      
      <div id="modalBody" class="modal-body">
              
        <div class="form-group row">
          <div class="col-md-4">
             <label class="control-label" for="number">
                新增实验器材数目：
             </label>   
          </div>
          <div class="col-md-8">
              <input id="number" type="text" class="form-control col-md-8" placeholder="请输入新增的实验器材数目：">
          </div>
        </div>
                  
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="pulsReturn">取消</button>
        <button type="button" class="btn btn-primary" id="pulsSubmit">保存</button>
      </div>
    
    </div>
  </div>
</div>