
/**
 * @param {number[]} A
 * @return {boolean}
 */
// var isMonotonic = function(A) {
//     if (A.length == 1 || A.length == 2){
//         return true
//     }
//     let result = 0
//     if (A[0] > A[1]){
//         result = 1
//     } else if(A[0] < A[1]){
//         result = 2
//     }
//     for (let p = 1; p <= A.length-2; p++) {
//         let pre = result
//         if (A[p] > A[p+1]){
//             result = 1
//         } else if(A[p] < A[p+1]){
//             result = 2
//         }
//         if (pre != 0 && pre != result){
//             return false
//         }
//         if (p == A.length-2){
//             if (((A[p-1] <= A[p]) && (A[p] <= A[p+1])) ){
//                 return true
//             } else if ((((A[p-1] >= A[p]) && A[p] >= A[p+1]))){
//                 return true
//             } else {
//                 return false
//             }
//         }
//         if (((A[p-1] <= A[p]) && (A[p] <= A[p+1])) && (result != 1) ){
//             continue
//         } else if ((((A[p-1] >= A[p]) && A[p] >= A[p+1])) && (result != 2)){
//             continue
//         } else {
//             return false
//         }   
//     }
// };
var isMonotonic = function(A) {
    if (A.length == 1 || A.length == 2){
        return true
    }
    return isInCreasing(A) || isDecreasing(A)
};
let isInCreasing = function(A) {
    for (let i = 0; i < A.length-1; i++) {
       if(A[i] < A[i+1]) {
        return false
       }
    }
    return true
}

let isDecreasing = function(A){
    for (let i = 0; i < A.length-1; i++) {
      if(A[i] > A[i+1]) {
        return false
       }
    }
    return true
}

// let recursive = function(A, p, result){
//     let pre = result
//     if (A[p] > A[p+1]){
//         result = 1
//     } else if(A[p] < A[p+1]){
//         result = 2
//     }
//     if (p == A.length-2){
//         if (((A[p-1] <= A[p]) && (A[p] <= A[p+1])) ){
//             return true
//         } else if ((((A[p-1] >= A[p]) && A[p] >= A[p+1]))){
//             return true
//         } else {
//             return false
//         }
//     }
    
//     if (pre != 0 && pre != result){
//         return false
//     }
//     if (((A[p-1] <= A[p]) && (A[p] <= A[p+1])) && (result != 1) ){
//         return recursive(A, ++p, result)
//     } else if ((((A[p-1] >= A[p]) && A[p] >= A[p+1])) && (result != 2)){
//         return recursive(A, ++p,result)
//     } else {
//         return false
//     }
// }

console.log(isMonotonic([1,2,2,3]) == true)
console.log(isMonotonic([6,5,4,4]) == true)
console.log(isMonotonic([1,3,2]) == false)
console.log(isMonotonic([1,2,4,5]) == true)
console.log(isMonotonic([1,1,1]) == true)

console.log(isMonotonic([1,1,2]) == true)

console.log(isMonotonic([1,1,0]) == true)

console.log(isMonotonic([2,2,2,1,4,5]) == false)

console.log(isMonotonic([-5,-5,-5,-5,-2,-2,-2,-1,-1,-1,0]) == true)

console.log(isMonotonic([11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5]) == false)

console.log(isMonotonic([-2, -2, -2, -1, -1, -1, 1, 1,1,1,,1,1,1,1,0]) == false)
