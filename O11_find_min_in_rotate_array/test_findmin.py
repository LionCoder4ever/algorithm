from findmin import findMin
import unittest

class TestFindMin(unittest.TestCase):

    def testInvalidInputNull(self):
        with self.assertRaises(ValueError):
            findMin([])

    def testInvalidInputStr(self):
        with self.assertRaises(ValueError):
            findMin('str')

    def testInvalidInputSeq(self):
        with self.assertRaises(ValueError):
            findMin([3,5,5,1,'A'])

    def testValidInput(self):
        self.assertEqual(1, findMin([3,4,5,1,2]))

    def testValidInputOrigin(self):
        self.assertEqual(1, findMin([1,2,3,4,5]))
    
    def testValidInputEqual(self):
        self.assertEqual(0, findMin([1,1,1,0,1]))

if __name__ == '__main__':
    unittest.main()