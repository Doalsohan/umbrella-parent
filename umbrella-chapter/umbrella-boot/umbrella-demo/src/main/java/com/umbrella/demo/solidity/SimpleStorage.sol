// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.16 <0.9.0;

contract SimpleStorage {
    uint storedData;
    
    constructor(){

    }

    // uint  无符号整形256位
    function set(uint x) public {
        storedData = x;
    }

    // returns后面的表示返回值的类型
    function get() public view returns(uint) {
        return storedData;
    }
}
