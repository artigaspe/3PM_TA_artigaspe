//
//  ViewController.swift
//  HelloWorldDayOne
//
//  Created by pvesat on 12/1/23.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var helloLabel: UILabel!
    @IBOutlet weak var swapButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    
    @IBAction func selectedSwapButton(_ sender: Any) {
        self.helloLabel.text = "XCodeRules"
    }
    
}

