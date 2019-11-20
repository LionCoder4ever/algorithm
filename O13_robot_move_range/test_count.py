import unittest
from count import movingCountByVisited, movingCountByAdd

class TestCount(unittest.TestCase):

    def testInvalidInputNull(self):
        with self.assertRaises(ValueError):
            movingCountByVisited(0,2,5)

    def testValidInput(self):
        self.assertEqual(movingCountByVisited(10,10,5),21)
        self.assertEqual(movingCountByVisited(20,20,15),359)
        self.assertEqual(movingCountByVisited(1,100,10),29)
        self.assertEqual(movingCountByVisited(1,10,10),10)
        self.assertEqual(movingCountByVisited(100,1,15),79)
        self.assertEqual(movingCountByVisited(10,1,15),10)

    def testValidInputByAdd(self):
        self.assertEqual(movingCountByAdd(10,10,5),21)
        self.assertEqual(movingCountByAdd(20,20,15),359)
        self.assertEqual(movingCountByAdd(1,100,10),29)
        self.assertEqual(movingCountByAdd(1,10,10),10)
        self.assertEqual(movingCountByAdd(100,1,15),79)
        self.assertEqual(movingCountByAdd(10,1,15),10)


if __name__ == '__main__':
    unittest.main()