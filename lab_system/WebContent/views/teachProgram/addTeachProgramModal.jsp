<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 新增教学资源模态框（Modal） -->
<div class="modal fade" id="addTeachProgramModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
     <div class="modal-content">
             <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">
                     <span>添加教学资源</span>                   
                 </h4>
                 
             </div>
      
      <div id="modalBody" class="modal-body">
          
          <div id="state" class="form-group">
              <input id="fileupload" type="file" name="file" multiple style="display: none;">
              <button id="file" class="btn btn-primary">选择文件</button>
              <button id="add" class="btn btn-success disabled">上传文件</button> 
              <div id="showFileName" style="padding-top: 2px;text-align: center;color: green">
                 <span>请选择文件</span>
              </div>            
          </div>
          
          <div id="progress" class="form-group">
              <div class="bar" style="width: 0%;height: 18px;background: green;"></div>
              <br>
              <div id="warn" style="color: blue;text-align: center;font-size: 120%;">
              
              </div>
          </div>     
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="addReturn">关闭</button>
        <!-- 
            <button type="button" class="btn btn-primary" id="addSubmit">保存</button>
         -->      
      </div>
    
    </div>
  </div>
</div>

<!-- 文件上传js -->
<script type="text/javascript" src="assets/jquery-fileupload/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript" src="assets/jquery-fileupload/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="assets/jquery-fileupload/js/jquery.fileupload.js"></script>