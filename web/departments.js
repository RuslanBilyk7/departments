/**
 * Created by RUSLAN77 on 19.03.2018.
 */
function validateForm() {
//    required pattern="^[a-zA-Z]+$"
    var x = document.myForm.departmentName.value;
    if (x.trim() == "") {
        alert("Name must be filled out");
        return false;
    }


    if (!x.trim().match(/(^[a-zA-Z-_]+$)/)) {
        alert("wrong symbol");
        return false;


            //
            //var letters = /^[A-Za-z]+$/;
            //if(x.match(letters))
            //{
            //    return true;
            //}
            //else
            //{
            //    alert("message");
            //    return false;

    }
}

