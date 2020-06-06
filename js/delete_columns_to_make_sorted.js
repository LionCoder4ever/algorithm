/**
 * @param {string[]} A
 * @return {number}
 */
var minDeletionSize = function(A) {
    return core2(A)
};
let core = function (A) {
    let n = []
    for (let i = 0; i< A.length-1; i++) {
        n = compare(n, A[i], A[i+1])
        if (n.length == A.length) {
            return A.length
        }
    }
    return n.length
}
let compare = function(n, first, second) {
    for (let i =0; i< first.length; i++) {
        if (n.findIndex((e) => e==i) != -1) {
            continue
        }
        if (first[i] >second[i]) {
            n.push(i)
        }
    }
    return n
}

let core1 = function(A) {
    let n = 0
    for (let i = 0; i <A[0].length; i++){
       for (let j=0;j<A.length-1;j++ ) {
           if (A[j][i]>A[j+1][i]){
               n++
               if (n == A.length){
                   return n
               }
               break
           }
        }
    }
    return n
}
let core2 = function(A) {
    let n = 0
    for (let i = 0; i <A[0].length; i++){
        for (let j=0;j<A.length-1;j++ ) {
            if (A[j].charAt(i)>A[j+1].charAt(i)){
                n++
                if (n == A.length){
                    return n
                }
                break
            }
        }
    }
    return n
}
let a  = minDeletionSize(["cba","daf","ghi"])
console.log(a)

a  = minDeletionSize(['a', 'b'])
console.log(a)


a  = minDeletionSize(["zyx","wvu","tsr"])
console.log(a)


a =  minDeletionSize(["egguij","gjsnnk","lstgon","ztzrqv"])
console.log(a)

a = minDeletionSize(["rrjk","furt","guzm"])
console.log(a)
