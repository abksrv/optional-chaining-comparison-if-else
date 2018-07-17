    if(check1(obj) != null)
        doSomething(check1(obj))
    else if(check2(obj) != null)
        doSomething(check2(obj))
    /*..*/
    else if(checkN(obj) != null)
        doSomething(checkN(obj))
/*where check1..checkN are homogeneous checks on obj with same return type.*/
