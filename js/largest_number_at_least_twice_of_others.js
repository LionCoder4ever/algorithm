/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
    if (nums <= 1){
        return 0 
    }
    let m = Math.max(...nums)
    let mIndex = nums.indexOf(m)
    for (let i = 0; i < nums.length; i++) {
        if ((i != mIndex) && (m < (nums[i] << 1))){
            return -1
        }
    }
    return mIndex 
};

console.log(dominantIndex([1,2,16,35,44,100,27,0]))

// console.log([3,6,1,0].indexOf(6))
