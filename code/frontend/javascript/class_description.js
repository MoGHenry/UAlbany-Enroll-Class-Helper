function show_description(class_json)
{

    btn_close_2.onclick = function (){
        modal.style.display = "none";
    }

    btn_add.onclick = function (){
        modal.style.display = "none";
        // TODO add to cart
    }
}

function addModal() {
    document.getElementById('class-description').innerHTML += '' +
        '<!-- The Modal -->\n' +
        '<div id="modal" class="modal">\n' +
        '\n' +
        '  <!-- Modal content -->\n' +
        '  <div class="modal-content">\n' +
        '\n' +
        '    <div class="modal-header">\n' +
        '      <div><h5 class="modal-title">ICSI 418Y</h5></div>\n' +
        '\n' +
        '\n' +
        '\n' +
        '      <button type="button" id="btn-close-1" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>\n' +
        '    </div>\n' +
        '    <div class="modal-body">\n' +
        '      <div>\n' +
        '        <h6>\n' +
        '          <table class="table table-below">\n' +
        '            <tr>\n' +
        '              <th>University At Albany</th>\n' +
        '              <th>Spring 2023</th>\n' +
        '              <th>Lecture</th>\n' +
        '            </tr>\n' +
        '          </table>\n' +
        '        </h6>\n' +
        '      </div>\n' +
        '\n' +
        '      <table class="table table-hover class-table">\n' +
        '        <th scope="row">Class detail</th>\n' +
        '        <tr>\n' +
        '          <td>\n' +
        '            <table>\n' +
        '              <tr>\n' +
        '                <th>Status</th>\n' +
        '                <td>Open</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Class Number</th>\n' +
        '                <td>5504</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Session</th>\n' +
        '                <td>Semester Length</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Units</th>\n' +
        '                <td>3 Units</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Class Component</th>\n' +
        '                <td>Lecture Required</td>\n' +
        '              </tr>\n' +
        '            </table>\n' +
        '          </td>\n' +
        '          <td>\n' +
        '            <table>\n' +
        '              <tr>\n' +
        '                <th>Career</th>\n' +
        '                <td>undergraduate</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Dates</th>\n' +
        '                <td>1/18/2023</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Grading</th>\n' +
        '                <td>Graded</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Location</th>\n' +
        '                <td>Uptown Albany Campus</td>\n' +
        '              </tr>\n' +
        '              <tr>\n' +
        '                <th>Campus</th>\n' +
        '                <td>University at Albany</td>\n' +
        '              </tr>\n' +
        '            </table>\n' +
        '          </td>\n' +
        '        </tr>\n' +
        '        <th scope="row">Meeting Information</th>\n' +
        '        <tr>\n' +
        '\n' +
        '        </tr>\n' +
        '        <th scope="row">Enrollment Information</th>\n' +
        '        <tr>\n' +
        '          <td></td>\n' +
        '        </tr>\n' +
        '        <th scope="row">Class Availability</th>\n' +
        '        <tr>\n' +
        '\n' +
        '        </tr>\n' +
        '        <th scope="row">Notes</th>\n' +
        '        <tr>\n' +
        '\n' +
        '        </tr>\n' +
        '        <th scope="row">Description</th>\n' +
        '        <tr>\n' +
        '\n' +
        '        </tr>\n' +
        '      </table>\n' +
        '\n' +
        '    </div>\n' +
        '    <div class="modal-footer">\n' +
        '      <button type="button" id="btn-close-2" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>\n' +
        '      <button type="button" id="btn-add" class="btn btn-primary">Add to Cart</button>\n' +
        '    </div>\n' +
        '\n' +
        '  </div>\n' +
        '\n' +
        '</div>' +
        '';
}
