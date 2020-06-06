/**
 * @param {string} text
 * @param {string} first
 * @param {string} second
 * @return {string[]}
 */
var findOcurrences = function(text, first, second) {
    let arr = text.split(' ')
    let res = []
    let tmp = [] 
    for (let i = 0; i < arr.length; i++) {
        if (tmp.length == 0) {
            if (arr[i] == first) {
                tmp.push(arr[i])
            }
        } else if (tmp.length == 1) {
            if (arr[i] == first) {
               // do nothing 
            } else if (arr[i] == second) {
                tmp.push(arr[i])
            } else {
                tmp = []
            }
        } else if (tmp.length == 2) {
            res.push(arr[i])
            if (arr[i] == first) {
                tmp.pop()
            } else {
                tmp = []
            }
        }
    }
    return res
};
let text = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa"
, first = "kcyxdfnoa", second = "jkypmsxd"
console.log(findOcurrences(text, first, second))
