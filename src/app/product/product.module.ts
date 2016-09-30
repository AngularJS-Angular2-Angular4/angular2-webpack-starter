import { NgModule }                     from '@angular/core';
import { FormsModule }                  from '@angular/forms';
import { CommonModule }                 from '@angular/common';
import { ProductDescriptionComponent }  from './product-desc.component';
import { ProductPricingComponent }      from './product-pricing.component';
import { CheckmarkPipe }                from '../common/pipes/checkmark.pipe';
import { ProductTermSelectionComponent } from './product-term-selection.component';

@NgModule({
    imports: [ FormsModule,
    CommonModule],
    exports: [ ProductDescriptionComponent,
                ProductPricingComponent,
                ProductTermSelectionComponent,
                CheckmarkPipe ],
    declarations: [ ProductDescriptionComponent ,
                    ProductPricingComponent,
                ProductTermSelectionComponent,
                    CheckmarkPipe ],
    providers: [],
})
export class ProductModule { }
